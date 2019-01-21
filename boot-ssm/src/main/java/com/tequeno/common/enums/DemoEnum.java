package com.tequeno.common.enums;

public enum DemoEnum {
    DEFAULT_ORDER("orderby", "create_time desc"),
    ;
    private String code;
    private String value;

    DemoEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
