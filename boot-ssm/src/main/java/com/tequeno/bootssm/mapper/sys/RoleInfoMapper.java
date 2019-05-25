package com.tequeno.bootssm.mapper.sys;

import com.tequeno.bootssm.pojo.sys.role.RoleInfo;
import com.tequeno.bootssm.pojo.sys.role.RoleInfoQuery;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleInfoMapper extends Mapper<RoleInfo> {

    List<RoleInfo> selectAllByCondition(RoleInfoQuery query);
}