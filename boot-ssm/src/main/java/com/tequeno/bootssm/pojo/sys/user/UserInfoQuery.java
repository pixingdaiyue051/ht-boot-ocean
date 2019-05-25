package com.tequeno.bootssm.pojo.sys.user;

import com.tequeno.common.constants.CommonQuery;

public class UserInfoQuery extends CommonQuery {

    private String userName;

    private String trueName;

    private String userNameLike;

    private String trueNameLike;

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

    public String getUserNameLike() {
        return userNameLike;
    }

    public void setUserNameLike(String userNameLike) {
        this.userNameLike = userNameLike;
    }

    public String getTrueNameLike() {
        return trueNameLike;
    }

    public void setTrueNameLike(String trueNameLike) {
        this.trueNameLike = trueNameLike;
    }
}