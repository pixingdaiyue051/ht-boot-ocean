package com.tequeno.common.enums;

public enum ResultCodeMsgEnum {
    SUCCESS("1", "成功"),
    FAIL("0", "失败"),
    UNKNOW("-1","未知错误"),
    BUSSY("E-001","服务繁忙"),
    INTERNAL("E-002","系统异常"),
    ;
    private String code;
    private String msg;

    ResultCodeMsgEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
