package com.tequeno.common.constants;

public class HtCommonConstant {
    /**
     * 当前页码
     */
    public final static String CURRENTPAGE = "currentPage";
    /**
     * 分页参数
     */
    public final static String LIMIT = "limit";
    /**
     * 默认分页的查询方法,返回dto
     */
    public static final String SELECTALLBYCONDITION = "selectAllByCondition";
    /**
     * 默认分页的查询方法,返回map
     */
    public static final String SELECTMAPBYCONDITION = "selectMapByCondition";
    /**
     * 自定义方法关键字(主要用于判断,表达式右边的值无所谓)
     */
    public static final String ANOTHERMETHOD = "anotherMethod";
    /**
     * 排序关键字
     */
    public static final String ORDERBY = "orderby";
    /**
     * modalMap中加载成功与否标志
     */
    public static final String SUCCESS = "success";
    /**
     * modalMap中加载失败时的提示词
     */
    public static final String ERRORMSG = "errorMsg";
    /**
     * modalMap中加载成功时的提示词
     */
    public static final String DATA = "data";

    /**
     * 启用
     */
    public static final int ENABLE = 1;

    /**
     * 禁用
     */
    public static final int DISENABLE = 0;

    /**
     * 数字字符串，应用于获取随机数验证码
     */
    public static final String NUMBER_STR = "0123456789";

    /**
     * 验证码长度
     */
    public static final int OPT_LENGTH = 6;

    /**
     * 验证码失效时间 10 分钟
     */
    public static final long OPT_EXPIRED = 600L;
}
