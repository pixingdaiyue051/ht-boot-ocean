package com.tequeno.client.controller;

import com.tequeno.client.entity.Area;
import com.tequeno.client.mapper.AreaMapper;
import com.tequeno.client.service.BaseServiceImpl;
import com.tequeno.common.constants.CommonConstants;
import com.tequeno.common.utils.ResultBinder;
import com.tequeno.common.utils.ResultBinderUtil;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Transactional
@RequestMapping("area")
public class AreaController extends BaseServiceImpl<AreaMapper, Area> {

    @PostMapping("list")
    public ResultBinder list(@RequestParam Map<String, Object> map) {
        map.put(CommonConstants.ORDERBY, "priority desc");
        List<Area> list = super.getList(map);
        if (list != null && !list.isEmpty()) {
            list.forEach(item -> System.out.println(item.getAreaName()));
            System.out.println(list.stream().distinct().count());
        }
        return ResultBinderUtil.success(list);
    }
}
