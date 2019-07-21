package com.tequeno.bootssm.pojo.sys.res;

import com.tequeno.bootssm.pojo.BaseEntity;

import javax.persistence.Table;

@Table(name = "um_role_info")
public class RoleInfo extends BaseEntity {

    private static final long serialVersionUID = 5814857732906911449L;

    private String roleCode;

    private String roleName;

    private String remark;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}