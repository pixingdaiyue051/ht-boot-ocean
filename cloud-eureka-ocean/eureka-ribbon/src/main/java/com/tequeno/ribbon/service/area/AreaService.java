package com.tequeno.ribbon.service.area;

import com.tequeno.ribbon.entity.Area;
import com.tequeno.ribbon.service.base.BaseService;

import java.util.List;
import java.util.Map;

public interface AreaService extends BaseService<Area> {
    int insertBatch(List<Area> areaList);

    int updateBatch(List<Area> areaList);

    int deleteByCondition(Map<String, Object> map);
}
