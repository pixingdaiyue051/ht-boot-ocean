package com.tequeno.bootssm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tequeno.config.cache.JedisCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.lang.reflect.Method;
import java.util.List;

public class BaseServiceImpl<D extends Mapper<T>, T, Q> implements BaseService<T, Q> {

    @Autowired
    protected D mapper;

    @Autowired
    protected JedisCacheUtil cacheUtil;

    @Override
    @Transactional
    public T selectByPrimaryKey(Object id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void deleteByPrimaryKey(Object id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    @Transactional
    public void insertSelective(T entity) {
        mapper.insertSelective(entity);
    }

    @Override
    @Transactional
    public void updateSelective(T entity) {
        mapper.updateByPrimaryKeySelective(entity);
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