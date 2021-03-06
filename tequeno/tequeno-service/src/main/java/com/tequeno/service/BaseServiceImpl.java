package com.tequeno.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tequeno.config.RedisUtil;
import com.tequeno.constants.HtCommonPageInfo;
import com.tequeno.enums.HtCommonErrorEnum;
import com.tequeno.enums.JedisKeyPrefixEnum;
import com.tequeno.utils.HtCommonException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.List;

public class BaseServiceImpl<D extends Mapper<T>, T, Q> implements BaseService<T, Q> {

    private final static Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Resource
    protected D mapper;

    @Resource
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
        Object obj = redisUtil.get(key);
        if (null != obj) {
            return (T) obj;
        }
        T t = mapper.selectByPrimaryKey(id);
        if (null != t) {
            redisUtil.set(key, t);
            return t;
        }
        throw new HtCommonException(HtCommonErrorEnum.OBJECT_NOT_FETCHED);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public int updateSelective(Object id, T entity, JedisKeyPrefixEnum prefixEnum) {
        final String key = prefixEnum.assemblyKey(id);
        redisUtil.del(key);
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public int deleteByPrimaryKey(Object id, JedisKeyPrefixEnum prefixEnum) {
        final String key = prefixEnum.assemblyKey(id);
        redisUtil.del(key);
        return mapper.deleteByPrimaryKey(id);
    }

}
