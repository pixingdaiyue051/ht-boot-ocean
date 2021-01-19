package com.tequeno.enums;

/**
 * @Desription:
 * @Author: hexk
 */
public enum JedisSeqPrefixEnum {
    TEST("TEST", "测试用"),
    ;
    private String prefix;
    private String msg;

    JedisSeqPrefixEnum(String prefix, String msg) {
        this.prefix = prefix;
        this.msg = msg;
    }

    public String getPrefix() {
        return prefix;
    }

    public String assemblySeq(Object SeqNum) {
        return prefix + SeqNum;
    }
}
