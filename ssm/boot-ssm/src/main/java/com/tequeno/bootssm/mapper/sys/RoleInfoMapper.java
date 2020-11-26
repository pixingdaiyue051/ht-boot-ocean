package com.tequeno.bootssm.mapper.sys;

import com.tequeno.bootssm.pojo.sys.res.RoleInfo;
import com.tequeno.bootssm.pojo.sys.res.UserRoleResQuery;
import com.tequeno.bootssm.pojo.sys.res.ViewUserRoleRes;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

;

public interface RoleInfoMapper extends Mapper<RoleInfo> {

    List<RoleInfo> selectAllByCondition(UserRoleResQuery query);

    int deleteUserRole(@Param("userId") Long userId, @Param("roleId") Long roleId, @Param("roleCode") String roleCode);

    List<ViewUserRoleRes> selectUserRole(UserRoleResQuery query);
}