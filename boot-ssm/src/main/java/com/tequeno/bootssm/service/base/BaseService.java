package com.tequeno.bootssm.service.base;

import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BaseService<T, Q> {
    /**
     * 根据主键查找在实体类
     *
     * @param id
     * @return 对应的实体类
     */
    T selectByPrimaryKey(Object id);

    /**
     * 查询对应表的全部数据相当于select *,如非必要,勿用此接口
     *
     * @return 全部记录的集合
     */
    @Deprecated
    List<T> selectAll();

    /**
     * 插入一条记录,属性为null的不会被插入,成功后该实体类中会有新生成的id
     *
     * @param entity
     */
    void insertSelective(T entity);

    /**
     * 根据主键更新记录,属性为null的不会被更新,推荐使用时将不需要更新的字段主动设置为null
     *
     * @param entity
     */
    void updateSelective(T entity);

    /**
     * 根据主键删除记录
     *
     * @param id
     */
    void deleteByPrimaryKey(Object id);

    /**
     * 根据条件查询记录,map的key要和mapper里面的判断字段名字一致
     *
     * @param q 查询参数query
     * @return 符合条件的记录集合
     */
    List<T> getList(Q q);

    /**
     * 根据条件查询记录,map的key要和mapper里面的判断字段名字一致
     *
     * @param q 查询参数query
     * @return 符合条件的记录分页集合
     */
    PageInfo<T> findPager(Q q);

}