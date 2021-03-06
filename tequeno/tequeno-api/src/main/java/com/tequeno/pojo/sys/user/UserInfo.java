package com.tequeno.pojo.sys.user;

import com.tequeno.pojo.BaseEntity;

import javax.persistence.Table;

@Table(name = "um_user_info")
public class UserInfo extends BaseEntity {

    private final static long serialVersionUID = -403886687529880018L;

    private String userName;

    private String trueName;

    private Integer enabled;

    private String email;

    private String phoneNum;

    private String contactInfo;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}