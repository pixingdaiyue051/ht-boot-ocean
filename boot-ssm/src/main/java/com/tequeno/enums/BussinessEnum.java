package com.tequeno.enums;

import com.tequeno.common.enums.CommonCodeMsgInterface;

public enum BussinessEnum implements CommonCodeMsgInterface {
    USER_NOT_EXIST("1001", "用户不存在"),
    USERNAME_NOT_EMPTY("1002", "用户名不为空"),
    PASSWORD_NOT_EMPTY("1003", "密码不为空"),
    PHONE_NOT_MATCHED("1004", "手机号码不正确"),
    MAIL_NOT_MATCHED("1005", "邮箱不正确"),
    ID_NOT_MATCHED("1006", "id不为空"),
    TRUENAME_NOT_EMPTY("1007", "真实姓名不为空"),
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
