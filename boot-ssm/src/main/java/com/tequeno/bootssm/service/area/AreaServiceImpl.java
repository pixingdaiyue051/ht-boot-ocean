package com.tequeno.bootssm.service.area;

import com.tequeno.bootssm.mapper.area.AreaMapper;
import com.tequeno.bootssm.mapper.sys.UserInfoMapper;
import com.tequeno.bootssm.pojo.area.Area;
import com.tequeno.bootssm.pojo.area.AreaQuery;
import com.tequeno.bootssm.pojo.sys.user.UserInfo;
import com.tequeno.bootssm.service.BaseServiceImpl;
import com.tequeno.common.enums.HtCommonErrorEnum;
import com.tequeno.common.utils.HtCommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AreaServiceImpl extends BaseServiceImpl<AreaMapper, Area, AreaQuery> implements AreaService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void testInsertUser(int i) {
        try {
            UserInfo user = new UserInfo();
            user.setUserName("test" + i);
            user.setTrueName("test" + i);
            userInfoMapper.insertSelective(user);
            if (i == 2) {
                System.out.println(1 / 0);
            }
        } catch (Exception e) {
            throw new HtCommonException(HtCommonErrorEnum.SYSTEM_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void testInsertArea(int i) {
        try {
            Area area = new Area();
            area.setAreaName("test" + i);
            area.setPriority(7);
            mapper.insertSelective(area);
            if (i == 2) {
                System.out.println(1 / 0);
            }
        } catch (Exception e) {
            throw new HtCommonException(HtCommonErrorEnum.SYSTEM_ERROR);
        }
    }
}
