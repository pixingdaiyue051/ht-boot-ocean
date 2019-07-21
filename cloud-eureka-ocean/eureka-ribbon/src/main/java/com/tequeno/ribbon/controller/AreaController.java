package com.tequeno.ribbon.controller;

import com.tequeno.common.constants.HtCommonConstant;
import com.tequeno.common.constants.ResultBinder;
import com.tequeno.common.utils.HtResultInfoWrapper;
import com.tequeno.ribbon.entity.Area;
import com.tequeno.ribbon.mapper.AreaMapper;
import com.tequeno.ribbon.service.BaseServiceImpl;
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
public class AreaController extends BaseServiceImpl<AreaMapper, Area> {

    @Autowired
    protected RestTemplate restTemplate;

    @PostMapping("list")
    public ResultBinder list(@RequestParam Map<String, Object> map) {
        map.put(HtCommonConstant.ORDERBY, "priority desc");
        List<Area> list = super.getList(map);
        if (list != null && !list.isEmpty()) {
            list.forEach(item -> System.out.println(item.getAreaName()));
            System.out.println(list.stream().distinct().count());
        }
        return HtResultInfoWrapper.success(list);
    }
}