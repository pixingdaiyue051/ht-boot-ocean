package com.tequeno.bootssm.enums;

import com.tequeno.common.enums.CommonCodeMsgInterface;

public enum BussinessEnum implements CommonCodeMsgInterface {
    USER_NOT_EXIST("1001", "用户不存在"),
    ;
    private String code;
    private String msg;

    BussinessEnum(String code, String msg) {
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
