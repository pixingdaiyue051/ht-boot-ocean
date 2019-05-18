package com.tequeno.ribbon.controller;

import com.tequeno.common.constants.DemoConstants;
import com.tequeno.common.utils.ResultBinder;
import com.tequeno.common.utils.ResultBinderUtil;
import com.tequeno.ribbon.entity.Area;
import com.tequeno.ribbon.entity.UmUserInfo;
import com.tequeno.ribbon.mapper.AreaMapper;
import com.tequeno.ribbon.service.area.AreaService;
import com.tequeno.ribbon.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@Transactional
@RequestMapping("area")
public class AreaController extends BaseServiceImpl<AreaMapper, Area> implements AreaService {

    @Autowired
    protected RestTemplate restTemplate;

    @PostMapping("list")
    public ResultBinder list(@RequestParam Map<String, Object> map) {
        map.put(DemoConstants.ORDERBY, "priority desc");
        List<Area> list = super.getList(map);
        if (list != null && !list.isEmpty()) {
            list.forEach(item -> System.out.println(item.getAreaName()));
            System.out.println(list.stream().distinct().count());
        }
        return ResultBinderUtil.success(list);
    }

    @Override
    @PostMapping("insert")
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
        return 0;
    }

    @Override
    public int deleteByCondition(Map<String, Object> map) {
        return 0;
    }

    @PostMapping("test/transcation")
    public ResultBinder test() {
        Area area = new Area();
        area.setAreaName("ribbon-222");
        super.insertSelective(area);
//            System.out.println(1 / 0);
//-------------------------------------------------------------

        UmUserInfo userInfo = new UmUserInfo();
        userInfo.setId("1221");
        userInfo.setUserName("ab111");
        userInfo.setTrueName("ab111");
        userInfo.setPwd("123456");
        ResultBinder rb = restTemplate.postForObject("http://eureka-client/user/addOne", userInfo, ResultBinder.class);
        System.out.println(rb.getMsg() + "===" + rb.getData());
        System.out.println(1 / 0);
        return ResultBinderUtil.success();
    }
}
