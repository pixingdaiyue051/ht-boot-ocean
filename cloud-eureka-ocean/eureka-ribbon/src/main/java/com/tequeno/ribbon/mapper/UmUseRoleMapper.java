package com.tequeno.ribbon.mapper;

import com.tequeno.ribbon.entity.UmUseRole;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UmUseRoleMapper extends Mapper<UmUseRole> {

    List<UmUseRole> selectAllByCondition(Map<String, Object> map);
}