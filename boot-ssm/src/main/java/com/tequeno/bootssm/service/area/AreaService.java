package com.tequeno.bootssm.service.area;

import com.tequeno.bootssm.pojo.area.Area;
import com.tequeno.bootssm.pojo.area.AreaQuery;
import com.tequeno.bootssm.service.base.BaseService;

import java.util.List;

public interface AreaService extends BaseService<Area, AreaQuery> {
    void insertBatch(List<Area> areaList);

    void updateBatch(List<Area> areaList);

    void deleteByCondition(AreaQuery query);
}
