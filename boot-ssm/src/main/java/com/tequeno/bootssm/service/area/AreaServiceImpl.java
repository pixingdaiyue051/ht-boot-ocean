package com.tequeno.bootssm.service.area;

import com.tequeno.bootssm.mapper.area.AreaMapper;
import com.tequeno.bootssm.pojo.area.Area;
import com.tequeno.bootssm.pojo.area.AreaQuery;
import com.tequeno.bootssm.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class AreaServiceImpl extends BaseServiceImpl<AreaMapper, Area, AreaQuery> implements AreaService {

    @Autowired
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