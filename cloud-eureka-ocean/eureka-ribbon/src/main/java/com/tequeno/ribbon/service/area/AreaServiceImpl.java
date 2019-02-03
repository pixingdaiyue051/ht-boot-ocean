package com.tequeno.ribbon.service.area;

import com.tequeno.ribbon.entity.Area;
import com.tequeno.ribbon.mapper.AreaMapper;
import com.tequeno.ribbon.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AreaServiceImpl extends BaseServiceImpl<AreaMapper, Area> implements AreaService {
    @Override
    public int insertBatch(List<Area> areaList) {
        return 0;
    }

    @Override
    public int updateBatch(List<Area> areaList) {
        return 0;
    }

    @Override
    public int deleteByCondition(Map<String, Object> map) {
        return 0;
    }
}
