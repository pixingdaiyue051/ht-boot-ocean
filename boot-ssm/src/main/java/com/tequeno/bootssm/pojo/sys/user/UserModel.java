package com.tequeno.bootssm.pojo.sys.user;

public class UserModel extends UserInfo {

    private static final long serialVersionUID = -1074474632361537219L;

    private String password;

    private String opt;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }
}