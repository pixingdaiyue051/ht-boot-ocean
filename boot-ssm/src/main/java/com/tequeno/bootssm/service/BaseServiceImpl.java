package com.tequeno.bootssm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.lang.reflect.Method;
import java.util.List;

public class BaseServiceImpl<D extends Mapper<T>, T, Q> implements BaseService<T, Q> {
    @Autowired
    protected D mapper;

    @Override
    @Transactional
    public T selectByPrimaryKey(Object id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteByPrimaryKey(Object id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
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
        return this.actualQuery(q, null, null);
    }

    @Override
    public PageInfo<T> findPager(Q q) {
        try {
            Class<?> superClass = q.getClass().getSuperclass();
            Object obj = superClass.newInstance();
            Method method = superClass.getDeclaredMethod("getCurrentPage");
            Integer currentPage = (Integer) method.invoke(obj);
            method = superClass.getDeclaredMethod("getPageSize");
            Integer pageSize = (Integer) method.invoke(obj);
            PageHelper.startPage(currentPage, pageSize);
            return new PageInfo<>(this.actualQuery(q, superClass, obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<T> actualQuery(Q q, Class<?> superClass, Object obj) {
        try {
            if (null == superClass) {
                superClass = q.getClass().getSuperclass();
                obj = superClass.newInstance();
            }
            Method loadMethod = superClass.getDeclaredMethod("getLoadMethod");
            String methodName = (String) loadMethod.invoke(obj);
            Method m = mapper.getClass().getMethod(methodName, q.getClass());
            return (List<T>) m.invoke(mapper, q);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}