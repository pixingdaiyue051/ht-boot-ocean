package com.tequeno.bootassembly.ws;


public enum NettyCodeEnum {

    SUCCESS("1000", "成功"),
    FAIL("1100", "失败"),
    EXCEPTION("1101", "异常"),

    HEART("2000", "心跳包"),
    SUB("2001", "订阅包"),
    BIZ("2002", "业务包"),

    CALL_APPLY("3000", "拨打确认"),
    AI_PUSH("3001", "敏感词提醒,陌生人闯入提醒"),

    IM_SERVICE_ONLINE("4000", "客服上线"),
    IM_SERVICE_SEND("4001", "客服发送一条消息"),
    IM_SERVICE_RECEIVE("4002", "客服接收一条消息"),
    IM_SERVICE_FETCH("4003", "客服获取最近联系的客户"),
    IM_USER_ONLINE("5000", "客户上线"),
    IM_USER_SEND("5001", "客户发送一条消息"),
    IM_USER_RECEIVE("5002", "客户接收一条消息"),
    IM_USER_BIND("5003", "客户连接到客服"),
    ;
    private final String code;

    private final String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    NettyCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
