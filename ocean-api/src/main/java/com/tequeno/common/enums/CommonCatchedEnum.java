package com.tequeno.common.enums;

public enum CommonCatchedEnum implements CommonCodeMsgInterface {
    SUCCESS("1", "成功"),
    FAIL("0", "失败"),
    SYSTEM_ERROR("-1", "系统异常"),

    PARAMETER_NOT_EMPTY("0000", "未接收到请求参数"),
    PARAMETER_NOT_MATCHED("0002", "参数类型不匹配"),
    PARAMETER_NOT_VALID("0003", "参数不全"),
    OBEJCT_NOT_FETCHED("0004", "未查询到指定数据"),
    PASSWORD_ENCODE_FAILED("9000", "密码加密失败"),
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