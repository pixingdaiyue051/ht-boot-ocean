package com.tequeno.common.enums;

public enum JedisKeyPrefixEnum {
    USER("USER:", "用户模块"),
    JEDIS("JEDIS:", "jedis测试"),
    TEST("TEST:", "编程范例测试用"),
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
}