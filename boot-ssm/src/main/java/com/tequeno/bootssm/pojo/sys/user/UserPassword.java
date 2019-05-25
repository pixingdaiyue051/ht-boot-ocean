package com.tequeno.bootssm.pojo.sys.user;

import com.tequeno.bootssm.pojo.BaseEntity;

import javax.persistence.Table;

@Table(name = "um_user_password")
public class UserPassword extends BaseEntity {

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