package com.tequeno.bootssm.service.area;

import com.tequeno.bootssm.entity.area.Area;
import com.tequeno.bootssm.mapper.AreaMapper;
import com.tequeno.bootssm.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AreaServiceImpl extends BaseServiceImpl<AreaMapper, Area> implements AreaService {

    @Override
    public int insertBatch(List<Area> areaList) {
        if (areaList != null && !areaList.isEmpty()) {
            for (Area area : areaList) {
                super.insertSelective(area);
            }
            return areaList.size();
        } else {
            return 0;
        }
    }

    @Override
    public int updateBatch(List<Area> areaList) {
        if (areaList != null && !areaList.isEmpty()) {
            for (Area area : areaList) {
                super.updateSelective(area);
            }
            return areaList.size();
        } else {
            return 0;
        }
    }

    @Override
    public int deleteByCondition(Map<String, Object> map) {
        return mapper.deleteByCondition(map);
    }
}
