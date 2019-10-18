package com.tequeno.common.enums;

public enum JedisMsgKeyEnum {
    TEST("MSG:TEST", "测试用例"),
    ;
    private String chanel;
    private String desc;

    JedisMsgKeyEnum(String chanel, String desc) {
        this.chanel = chanel;
        this.desc = desc;
    }

    public String getChanel() {
        return chanel;
    }
}