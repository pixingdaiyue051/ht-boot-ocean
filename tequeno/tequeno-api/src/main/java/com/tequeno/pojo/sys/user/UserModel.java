package com.tequeno.pojo.sys.user;

public class UserModel extends UserInfo {

    private final static long serialVersionUID = -1074474632361537219L;

    private String password;

    private String otp;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}