package com.tequeno.enums;

public enum HtBussnessErrorEnum implements HtErrorInterface {
    ;
    private String code;
    private String msg;

    HtBussnessErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public HtErrorInterface build(String msg) {
        this.msg = msg;
        return this;
    }
}