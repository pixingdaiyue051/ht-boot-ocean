package com.tequeno.iou.mapper.area;

import com.tequeno.iou.pojo.area.Area;
import com.tequeno.iou.pojo.area.AreaQuery;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AreaMapper extends Mapper<Area> {

    List<Area> selectAllByCondition(AreaQuery query);

    int deleteByCondition(AreaQuery query);
}