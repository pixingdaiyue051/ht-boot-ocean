package com.tequeno.ribbon.service;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {
    /**
     * 根据主键查找在实体类
     *
     * @param id
     * @return 对应的实体类
     */
    T selectByPrimaryKey(Integer id);

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
     * @return 受影响行数
     */
    Integer insertSelective(T entity);

    /**
     * 根据主键更新记录,属性为null的不会被更新,推荐使用时将不需要更新的字段主动设置为null
     *
     * @param entity
     * @return 受影响行数
     */
    Integer updateSelective(T entity);

    /**
     * 根据主键删除记录
     *
     * @param id
     * @return 受影响行数
     */
    Integer deleteByPrimaryKey(Integer id);

    /**
     * 根据条件查询记录,map的key要和mapper里面的判断字段名字一致
     *
     * @param map
     * @return 符合条件的记录集合
     */
    List<T> getList(Map<String, Object> map);

    /**
     * 根据条件查询记录,map的key要和mapper里面的判断字段名字一致
     *
     * @param map
     * @return 符合条件的记录分页集合
     */
    PageInfo<T> findPager(Map<String, Object> map);

    /**
     * 根据条件查询记录,map的key要和mapper里面的判断字段名字一致
     *
     * @param map
     * @return 符合条件的记录集合
     */
    List<Map<String, Object>> getListMap(Map<String, Object> map);

    /**
     * 根据条件查询记录,map的key要和mapper里面的判断字段名字一致
     *
     * @param map
     * @return 符合条件的记录分页集合
     */
    PageInfo<Map<String, Object>> findPagerMap(Map<String, Object> map);

}