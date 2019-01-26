package com.tequeno.ribbon.mapper;

import com.tequeno.ribbon.entity.Area;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface AreaMapper extends Mapper<Area> {

    List<Area> selectAllByCondition(Map<String, Object> map);
}