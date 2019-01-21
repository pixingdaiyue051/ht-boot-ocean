package com.tequeno.bootssm.service.area;

import com.tequeno.bootssm.entity.area.Area;
import com.tequeno.bootssm.service.base.BaseService;

import java.util.List;
import java.util.Map;

public interface AreaService extends BaseService<Area> {
    int insertBatch(List<Area> areaList);

    int updateBatch(List<Area> areaList);

    int deleteByCondition(Map<String, Object> map);
}
