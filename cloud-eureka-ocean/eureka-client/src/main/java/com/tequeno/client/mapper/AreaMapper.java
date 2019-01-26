package com.tequeno.client.mapper;

import com.tequeno.client.entity.Area;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface AreaMapper extends Mapper<Area> {

    List<Area> selectAllByCondition(Map<String, Object> map);
}