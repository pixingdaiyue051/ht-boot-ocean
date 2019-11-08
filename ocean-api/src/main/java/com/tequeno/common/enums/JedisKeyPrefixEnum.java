package com.tequeno.common.enums;

public enum JedisKeyPrefixEnum {
    USER("USER:", "用户模块"),

    SESSION("SESSION:", "session管理"),

    HTEST("HTEST:", "编程范例测试用hash key"),
    TEST("TEST:", "编程范例测试用普通key"),

    HDICT("HDICT:", "数据字典hash"),
    HUSER_PASSWORD("HPASSWORD", "用户密码模块"),
    HUSER_RES("HUSERRES:", "用户权限"),
    HROLE("HROLE", "角色模块"),
    HRES("HRES", "权限模块"),

    OTP("OTP:", "验证码"),
    LOCK("LOCK:", "分布式锁"),
    ;
    private String prefix;
    private String msg;

    JedisKeyPrefixEnum(String prefix, String msg) {
        this.prefix = prefix;
        this.msg = msg;
    }

    public String assemblyKey(Object key) {
        return this.prefix + key;
    }

    public String getPrefix() {
        return prefix;
    }
}