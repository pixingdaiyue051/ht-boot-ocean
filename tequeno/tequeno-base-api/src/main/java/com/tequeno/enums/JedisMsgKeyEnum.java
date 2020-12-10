package com.tequeno.enums;

public enum JedisMsgKeyEnum {
    TEST("MSG:TEST", "测试用例"),
    RELEASE_LOCK("RELEASE:LOCK", "测试分布式锁释放接口"),
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