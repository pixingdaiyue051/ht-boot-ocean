package com.tequeno.service.area;

import com.tequeno.mapper.area.AreaMapper;
import com.tequeno.pojo.area.Area;
import com.tequeno.pojo.area.AreaQuery;
import com.tequeno.service.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

@Service
public class AreaServiceImpl extends BaseServiceImpl<AreaMapper, Area, AreaQuery> implements AreaService {

    @Resource
    private TransactionTemplate transactionTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void testInsertArea1() {
        for (int i = 0; i < 5; i++) {
            Area area = new Area("test-1", 4);
            mapper.insertSelective(area);
            testInsertArea3();
        }
        System.out.println(1 / 0);
    }

    @Override
    public void testInsertArea2() {
        transactionTemplate.execute(status -> {
            for (int i = 0; i < 5; i++) {
                try {
                    if (i > 1) {
                        System.out.println(1 / 0);
                    }
                    Area area = new Area("test-2", 4);
                    mapper.insertSelective(area);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        });
    }

    @Override
    public void testInsertArea3() {
        Area area = new Area("test-3", 4);
        mapper.insertSelective(area);
    }
}