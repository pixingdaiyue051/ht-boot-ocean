package com.tequeno.ribbon.entity;

import javax.persistence.Table;
import java.util.Date;


@Table(name = "um_role_info")
public class UmRoleInfo {
    private String id;

    private String roleName;

    private String createById;

    private String modifyById;

    private Date createTime;

    private Date modifyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getCreateById() {
        return createById;
    }

    public void setCreateById(String createById) {
        this.createById = createById == null ? null : createById.trim();
    }

    public String getModifyById() {
        return modifyById;
    }

    public void setModifyById(String modifyById) {
        this.modifyById = modifyById == null ? null : modifyById.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}