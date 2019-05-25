package com.tequeno.bootssm.pojo.sys.user;

import com.tequeno.common.constants.CommonQuery;

public class UserPasswordQuery extends CommonQuery {

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