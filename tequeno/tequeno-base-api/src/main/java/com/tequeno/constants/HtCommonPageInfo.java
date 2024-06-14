package com.tequeno.constants;

public class HtCommonPageInfo {
    /**
     * 当前页码方法名
     */
    public final static String GET_CURRENT_PAGE = "getCurrentPage";
    /**
     * 当前分页大小方法名
     */
    public final static String GET_PAGE_SIZE = "getPageSize";
    /**
     * 默认分页的查询方法,返回dto
     */
    public final static String SELECT_ALL_BY_CONDITION = "selectAllByCondition";
    /**
     * 默认排序
     */
    public final static String ORDER_CLAUSE = "create_time desc";

    /**
     * 默认起始页码
     */
    public final static Integer CURRENT_PAGE = 1;
    /**
     * 默认分页大小
     */
    public final static Integer PAGE_SIZE = 10;
}
