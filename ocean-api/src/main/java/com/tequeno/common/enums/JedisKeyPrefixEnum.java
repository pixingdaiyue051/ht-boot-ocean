package com.tequeno.common.enums;

public enum JedisKeyPrefixEnum {
    USER("USER:", "用户模块"),
    ROLE("ROLE:", "角色模块"),
    RES("RES:", "权限模块"),

    JEDIS("JEDIS:", "jedis测试"),
    TEST("TEST:", "编程范例测试用"),

    HDATA("HDATA:", "数据字典hash"),
    HUSER_PASSWORD("HDATA:PASSWORD", "用户密码模块"),
    HUSER_OPT("HDATA:OPT", "验证码"),
    HUSER_RES("HRES:", "用户权限"),
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