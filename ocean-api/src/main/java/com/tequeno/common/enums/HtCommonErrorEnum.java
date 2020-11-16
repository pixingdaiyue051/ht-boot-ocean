package com.tequeno.common.enums;

public enum HtCommonErrorEnum implements HtErrorInterface {
    SUCCESS("0000", "成功"),
    FAIL("0001", "失败"),
    SYSTEM_ERROR("0003", "系统异常"),
    COMBINE_ERROR("0004", null),

    PARAMETER_NOT_EMPTY("0100", "未接收到请求参数"),
    PARAMETER_NOT_MATCHED("0101", "参数类型不匹配"),
    PARAMETER_NOT_VALID("0102", "参数不全"),
    OBEJCT_NOT_FETCHED("0103", "未查询到指定数据"),
    OTP_NULL_OR_EXIPRED("0104", "未匹配到验证码或者验证码已过期"),
    WRONG_OTP("0105", "验证码错误"),
    OTP_NOT_EMPTY("0107", "验证码不为空"),

    NOT_REPEATED_SUBMIT("0200", "请勿重复提交"),

    JMS_ERROR("0300", null),
    ;
    private String code;
    private String msg;

    HtCommonErrorEnum(String code, String msg) {
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