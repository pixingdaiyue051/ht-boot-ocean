package com.tequeno.common.enums;

public enum CommonCatchedEnum implements CommonCodeMsgInterface {
    SUCCESS("1", "成功"),
    FAIL("0", "失败"),
    SYSTEM_ERROR("-1", "系统异常"),

    PARAMETER_NOT_VALID("0001", "参数不全"),
    ;
    private String code;
    private String msg;

    CommonCatchedEnum(String code, String msg) {
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
    public void setMsg(String msg) {
        this.msg = msg;
    }
}