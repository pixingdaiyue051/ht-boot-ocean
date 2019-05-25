package com.tequeno.bootssm.controller;

import com.tequeno.bootssm.mapper.area.AreaMapper;
import com.tequeno.bootssm.mapper.sys.UserInfoMapper;
import com.tequeno.bootssm.pojo.area.Area;
import com.tequeno.bootssm.pojo.sys.user.UserInfo;
import com.tequeno.common.utils.ResultBinder;
import com.tequeno.common.utils.ResultBinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tran")
public class TransactionController {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private AreaMapper areaMapper;

    @PostMapping("test1")
    @Transactional
    public ResultBinder test1() {
        insertUserPlus();
        try {
            insertAreaPlus();
        } catch (Exception e) {
            throw e;
        }
        return ResultBinderUtil.success();
    }

    @PostMapping("test2")
    @Transactional
    public ResultBinder test2() {
        insertUser();
        insertArea();
        System.out.println(1 / 0);
        return ResultBinderUtil.success();
    }

    @Transactional
    public void insertUser() {
        UserInfo user = new UserInfo();
        user.setUserName("rok");
        user.setTrueName("而给我疼的");
        userInfoMapper.insertSelective(user);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertUserPlus() {
        UserInfo user = new UserInfo();
        user.setUserName("rok");
        user.setTrueName("而给我疼的");
        userInfoMapper.insertSelective(user);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void insertUserPlus2() {
        UserInfo user = new UserInfo();
        user.setUserName("rok");
        user.setTrueName("而给我疼的");
        userInfoMapper.insertSelective(user);
    }

    @Transactional
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("我问问");
        area.setPriority(7);
        areaMapper.insertSelective(area);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertAreaPlus() {
        Area area = new Area();
        area.setAreaName("我问问");
        area.setPriority(7);
        areaMapper.insertSelective(area);
        System.out.println(1 / 0);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void insertAreaPlus2() {
        Area area = new Area();
        area.setAreaName("我问问");
        area.setPriority(7);
        areaMapper.insertSelective(area);
    }
}
