package com.tequeno.bootssm.service.area;

import com.tequeno.bootssm.mapper.area.AreaMapper;
import com.tequeno.bootssm.pojo.area.Area;
import com.tequeno.bootssm.pojo.area.AreaQuery;
import com.tequeno.bootssm.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl extends BaseServiceImpl<AreaMapper, Area, AreaQuery> implements AreaService {
}
