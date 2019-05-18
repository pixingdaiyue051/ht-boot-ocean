package com.tequeno.bootssm.service.area;

import com.tequeno.bootssm.mapper.area.AreaMapper;
import com.tequeno.bootssm.pojo.area.Area;
import com.tequeno.bootssm.pojo.area.AreaQuery;
import com.tequeno.bootssm.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AreaServiceImpl extends BaseServiceImpl<AreaMapper, Area, AreaQuery> implements AreaService {

    @Override
    @Transactional
    public void insertBatch(List<Area> areaList) {
        if (areaList != null && !areaList.isEmpty()) {
            areaList.forEach(a -> super.insertSelective(a));
        }
    }

    @Override
    @Transactional
    public void updateBatch(List<Area> areaList) {
        if (areaList != null && !areaList.isEmpty()) {
            areaList.forEach(a -> super.updateSelective(a));
        }
    }

    @Override
    public void deleteByCondition(AreaQuery query) {
        mapper.deleteByCondition(query);
    }
}
