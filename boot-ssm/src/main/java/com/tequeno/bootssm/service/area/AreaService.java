package com.tequeno.bootssm.service.area;

import com.tequeno.bootssm.pojo.area.Area;
import com.tequeno.bootssm.pojo.area.AreaQuery;
import com.tequeno.bootssm.service.BaseService;

public interface AreaService extends BaseService<Area, AreaQuery> {

    void testInsertUser(int i);

    void testInsertArea(int i);
}