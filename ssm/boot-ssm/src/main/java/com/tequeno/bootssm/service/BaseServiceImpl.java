package com.tequeno.bootssm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tequeno.common.constants.HtCommonPageInfo;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.config.cache.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<D extends Mapper<T>, T, Q> implements BaseService<T, Q> {

    private final static Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Autowired
    protected D mapper;

    @Autowired
    protected RedisUtil redisUtil;

    @Override
    public T selectByPrimaryKey(Object id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    @Deprecated
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public List<T> getList(Q q) {
        try {
            Method m = mapper.getClass().getDeclaredMethod(HtCommonPageInfo.SELECT_ALL_BY_CONDITION, q.getClass());
            return (List<T>) m.invoke(mapper, q);
        } catch (Exception e) {
            logger.debug("BaseServiceImpl.getList出错:", e);
        }
        return null;
    }

    @Override
    public PageInfo<T> findPager(Q q) {
        try {
            Class<?> superClass = q.getClass().getSuperclass();
            Method method = superClass.getDeclaredMethod(HtCommonPageInfo.GET_CURRENT_PAGE);
            Integer currentPage = (Integer) method.invoke(q);
            method = superClass.getDeclaredMethod(HtCommonPageInfo.GET_PAGE_SIZE);
            Integer pageSize = (Integer) method.invoke(q);
            PageHelper.startPage(currentPage, pageSize);
            Method m = mapper.getClass().getDeclaredMethod(HtCommonPageInfo.SELECT_ALL_BY_CONDITION, q.getClass());
            return new PageInfo<>((List<T>) m.invoke(mapper, q));
        } catch (Exception e) {
            logger.debug("BaseServiceImpl.findPager出错:", e);
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public int insertSelective(T entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public int updateSelective(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public int deleteByPrimaryKey(Object id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public T selectByPrimaryKey(Object id, JedisKeyPrefixEnum prefixEnum) {
        final String key = prefixEnum.assemblyKey(id);
        Object o = Optional.ofNullable(redisUtil.get(key)).orElseGet(() -> {
            T t = selectByPrimaryKey(id);
            redisUtil.set(key, t);
            return t;
        });
        return (T) o;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public int updateSelective(Object id, T entity, JedisKeyPrefixEnum prefixEnum) {
        final String key = prefixEnum.assemblyKey(id);
        redisUtil.del(key);
        return updateSelective(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public int deleteByPrimaryKey(Object id, JedisKeyPrefixEnum prefixEnum) {
        final String key = prefixEnum.assemblyKey(id);
        redisUtil.del(key);
        return deleteByPrimaryKey(id);
    }

}