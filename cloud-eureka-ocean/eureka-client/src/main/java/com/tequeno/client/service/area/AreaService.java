package com.tequeno.client.service.area;

import com.tequeno.client.entity.Area;
import com.tequeno.client.service.base.BaseService;

import java.util.List;
import java.util.Map;

public interface AreaService extends BaseService<Area> {
    int insertBatch(List<Area> areaList);

    int updateBatch(List<Area> areaList);

    int deleteByCondition(Map<String, Object> map);
}
