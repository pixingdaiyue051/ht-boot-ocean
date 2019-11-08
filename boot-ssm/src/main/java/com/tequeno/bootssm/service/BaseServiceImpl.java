package com.tequeno.bootssm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.config.cache.JedisCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<D extends Mapper<T>, T, Q> implements BaseService<T, Q> {

    @Autowired
    protected D mapper;

    @Autowired
    protected JedisCacheUtil cacheUtil;

    @Override
    @Transactional(rollbackFor = Exception.class)
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
        return this.actualQuery(q, null);
    }

    @Override
    public PageInfo<T> findPager(Q q) {
        try {
            Class<?> superClass = q.getClass().getSuperclass();
            Method method = superClass.getDeclaredMethod("getCurrentPage");
            Integer currentPage = (Integer) method.invoke(q);
            method = superClass.getDeclaredMethod("getPageSize");
            Integer pageSize = (Integer) method.invoke(q);
            PageHelper.startPage(currentPage, pageSize);
            return new PageInfo<>(this.actualQuery(q, superClass));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(T entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateSelective(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Object id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public T selectByPrimaryKey(Object id, JedisKeyPrefixEnum prefixEnum) {
        final String key = prefixEnum.assemblyKey(id);
        Object o = Optional.ofNullable(cacheUtil.get(key)).orElseGet(() -> {
            T t = selectByPrimaryKey(id);
            cacheUtil.set(key, t);
            return t;
        });
        return (T) o;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateSelective(Object id, T entity, JedisKeyPrefixEnum prefixEnum) {
        final String key = prefixEnum.assemblyKey(id);
        cacheUtil.del(key);
        return updateSelective(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Object id, JedisKeyPrefixEnum prefixEnum) {
        final String key = prefixEnum.assemblyKey(id);
        cacheUtil.del(key);
        return deleteByPrimaryKey(id);
    }

    private List<T> actualQuery(Q q, Class<?> superClass) {
        try {
            if (null == superClass) {
                superClass = q.getClass().getSuperclass();
            }
            Method loadMethod = superClass.getDeclaredMethod("getLoadMethod");
            String methodName = (String) loadMethod.invoke(q);
            Method m = mapper.getClass().getDeclaredMethod(methodName, q.getClass());
            return (List<T>) m.invoke(mapper, q);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}