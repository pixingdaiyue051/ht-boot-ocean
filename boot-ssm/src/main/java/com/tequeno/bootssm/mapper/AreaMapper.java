package com.tequeno.bootssm.mapper;

import com.tequeno.bootssm.entity.area.Area;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface AreaMapper extends Mapper<Area> {

    List<Area> selectAllByCondition(Map<String, Object> map);

    int deleteByCondition(Map<String, Object> map);
}