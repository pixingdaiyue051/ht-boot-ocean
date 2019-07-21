package com.tequeno.ribbon.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tequeno.common.constants.HtCommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@Transactional
public class BaseServiceImpl<D extends Mapper<T>, T> implements BaseService<T> {
    @Autowired
    protected D mapper;

    @Override
    public T selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public Integer insertSelective(T entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public Integer updateSelective(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<T> getList(Map<String, Object> map) {
        try {
            String method = HtCommonConstant.SELECTALLBYCONDITION;
            if (map != null && !map.isEmpty()) {
                if (map.containsKey(HtCommonConstant.ANOTHERMETHOD)) {
                    method = map.get(HtCommonConstant.ANOTHERMETHOD).toString();
                }
            }
            Method m = mapper.getClass().getMethod(method, Map.class);
            return (List<T>) m.invoke(mapper, map);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PageInfo<T> findPager(Map<String, Object> map) {
        int currentPage = (int) map.get(HtCommonConstant.CURRENTPAGE);
        int limit = (int) map.get(HtCommonConstant.LIMIT);
        PageHelper.startPage(currentPage, limit);
        return new PageInfo<>(this.getList(map));
    }

    @Override
    public List<Map<String, Object>> getListMap(Map<String, Object> map) {
        try {
            String method = HtCommonConstant.SELECTMAPBYCONDITION;
            if (map != null && !map.isEmpty()) {
                if (map.containsKey(HtCommonConstant.ANOTHERMETHOD)) {
                    method = map.get(HtCommonConstant.ANOTHERMETHOD).toString();
                }
            }
            Method m = mapper.getClass().getMethod(method, Map.class);
            return (List<Map<String, Object>>) m.invoke(mapper, map);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PageInfo<Map<String, Object>> findPagerMap(Map<String, Object> map) {
        int currentPage = (int) map.get(HtCommonConstant.CURRENTPAGE);
        int limit = (int) map.get(HtCommonConstant.LIMIT);
        PageHelper.startPage(currentPage, limit);
        return new PageInfo<>(this.getListMap(map));
    }
}