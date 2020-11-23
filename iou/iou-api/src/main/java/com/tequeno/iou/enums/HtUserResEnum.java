package com.tequeno.iou.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户与资源关联枚举，和数据库一一对应
 */
public enum HtUserResEnum {
    RES_USER_QUERY("2000", "用户查询"),
    RES_USER_UPDATE("2001", "用户更新"),
    RES_USER_ENABLE("2002", "用户启用禁用"),
    RES_USER_DELETE("2003", "用户删除"),
    RES_USER_ADD("2004", "用户新增"),
    RES_USER_BIND("2005", "用户信息绑定"),
    ;
    /**
     * 对应到数据库um_resource_info.res_code
     */
    private String code;
    /**
     * 对应到数据库um_resource_info.res_zh_name，仅具有参考意义，不可以出现在任何代码中
     */
    private String msg;

    private final static ThreadLocal<Map<String, String>> POOL = new ThreadLocal<>();

    HtUserResEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    @Deprecated
    public static Map<String, String> toMap() {
        Map<String, String> map = POOL.get();
        if (null == map) {
            map = new HashMap<>(11);
            HtUserResEnum[] values = values();
            for (HtUserResEnum userResEnum : values) {
                map.put(userResEnum.code, userResEnum.msg);
            }
            POOL.set(map);
        }
        return map;
    }

    @Deprecated
    public static void emptyPool() {
        POOL.remove();
    }

    @Deprecated
    public static String getMsgByCode(String code) {
        return toMap().get(code);
    }
}