package com.tequeno.client.mapper;

import com.tequeno.client.entity.UmRoleRes;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UmRoleResMapper extends Mapper<UmRoleRes> {

    List<UmRoleRes> selectAllByCondition(Map<String, Object> map);
}