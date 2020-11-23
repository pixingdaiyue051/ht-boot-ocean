package com.tequeno.bootssm.pojo.sys.res;

import com.tequeno.common.constants.HtCommonQuery;

public class UserRoleResQuery extends HtCommonQuery {

    private Long userId;

    private Long roleId;

    private Long resId;

    private String roleCode;

    private String resCode;

    private String userName;

    private String userNameLike;

    private String roleName;

    private String roleNameLike;

    private String resName;

    private String resNameLike;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getResId() {
        return resId;
    }

    public void setResId(Long resId) {
        this.resId = resId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNameLike() {
        return userNameLike;
    }

    public void setUserNameLike(String userNameLike) {
        this.userNameLike = userNameLike;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleNameLike() {
        return roleNameLike;
    }

    public void setRoleNameLike(String roleNameLike) {
        this.roleNameLike = roleNameLike;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResNameLike() {
        return resNameLike;
    }

    public void setResNameLike(String resNameLike) {
        this.resNameLike = resNameLike;
    }
}