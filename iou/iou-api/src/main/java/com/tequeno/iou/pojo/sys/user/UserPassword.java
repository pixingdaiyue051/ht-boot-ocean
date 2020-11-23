package com.tequeno.iou.pojo.sys.user;

import com.tequeno.iou.pojo.BaseEntity;

import javax.persistence.Table;

@Table(name = "um_user_password")
public class UserPassword extends BaseEntity {

    private final static long serialVersionUID = -7036271423748570086L;

    private Long userId;

    private String encryptPassword;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEncryptPassword() {
        return encryptPassword;
    }

    public void setEncryptPassword(String encryptPassword) {
        this.encryptPassword = encryptPassword == null ? null : encryptPassword.trim();
    }
}