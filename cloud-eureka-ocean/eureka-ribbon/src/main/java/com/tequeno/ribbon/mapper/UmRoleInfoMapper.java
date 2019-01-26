package com.tequeno.ribbon.mapper;

import com.tequeno.ribbon.entity.UmRoleInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UmRoleInfoMapper extends Mapper<UmRoleInfo> {

    List<UmRoleInfo> selectAllByCondition(Map<String, Object> map);
}