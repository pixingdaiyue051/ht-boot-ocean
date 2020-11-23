package com.tequeno.iou.mapper.sys;

import com.tequeno.iou.pojo.sys.res.ResourceInfo;
import com.tequeno.iou.pojo.sys.res.UserRoleResQuery;
import com.tequeno.iou.pojo.sys.res.ViewUserRoleRes;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ResourceInfoMapper extends Mapper<ResourceInfo> {

    List<ResourceInfo> selectAllByCondition(UserRoleResQuery query);

    int deleteRoleRes(@Param("resId") Long resId, @Param("roleId") Long roleId, @Param("resCode") String resCode);

    List<ViewUserRoleRes> selectUserRes(UserRoleResQuery query);
}