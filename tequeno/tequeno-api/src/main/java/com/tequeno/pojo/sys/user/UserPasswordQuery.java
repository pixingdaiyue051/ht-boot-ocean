package com.tequeno.pojo.sys.user;

import com.tequeno.constants.HtCommonQuery;

public class UserPasswordQuery extends HtCommonQuery {

    private Integer userId;

    private String encryptPassword;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEncryptPassword() {
        return encryptPassword;
    }

    public void setEncryptPassword(String encryptPassword) {
        this.encryptPassword = encryptPassword == null ? null : encryptPassword.trim();
    }
}