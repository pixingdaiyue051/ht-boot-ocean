package com.tequeno.bootssm.mapper.sys;

import com.tequeno.bootssm.pojo.sys.res.ResourceInfo;
import com.tequeno.bootssm.pojo.sys.res.UserRoleResQuery;
import com.tequeno.bootssm.pojo.sys.res.VUserRoleRes;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ResourceInfoMapper extends Mapper<ResourceInfo> {

    List<ResourceInfo> selectAllByCondition(UserRoleResQuery query);

    int deleteRoleRes(@Param("resId") Long resId, @Param("roleId") Long roleId, @Param("resCode") String resCode);

    List<VUserRoleRes> selectUserRes(UserRoleResQuery query);
}