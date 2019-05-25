package com.tequeno.bootssm.pojo.sys.role;

import com.tequeno.common.constants.CommonQuery;

public class RoleInfoQuery extends CommonQuery {

    private String roleName;

    private String roleNameLike;

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
}