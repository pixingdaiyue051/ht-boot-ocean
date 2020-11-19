package com.tequeno.common.enums;

/**
 * @Desription:
 * @Author: hexk
 */
public enum HtSeqPrefixEnum {
    TEST("TEST", "测试用"),
    ;
    private String prefix;
    private String msg;

    HtSeqPrefixEnum(String prefix, String msg) {
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
