package com.tequeno.client.mapper;

import com.tequeno.client.entity.UmRoleInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UmRoleInfoMapper extends Mapper<UmRoleInfo> {

    List<UmRoleInfo> selectAllByCondition(Map<String, Object> map);
}