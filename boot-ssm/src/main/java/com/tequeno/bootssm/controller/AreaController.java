package com.tequeno.bootssm.controller;

import com.tequeno.bootssm.entity.area.Area;
import com.tequeno.bootssm.mapper.AreaMapper;
import com.tequeno.bootssm.service.BaseServiceImpl;
import com.tequeno.common.constants.CommonConstants;
import com.tequeno.common.utils.ResultBinder;
import com.tequeno.common.utils.ResultBinderUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("area")
public class AreaController extends BaseServiceImpl<AreaMapper, Area> {

    @PostMapping("list")
    public ResultBinder list(@RequestParam Map<String, Object> map) {
        map.put(CommonConstants.ORDERBY, "priority desc");
        List<Area> list = super.getList(map);
        if (list != null && !list.isEmpty()) {
            list.forEach(item -> System.out.println(item.getAreaName()));
        }
        System.out.println(list.stream().distinct().count());
        return ResultBinderUtil.success(list);
    }

    @GetMapping("one/{id}")
    public ResultBinder one(@PathVariable Integer id) {
        return ResultBinderUtil.success(super.selectByPrimaryKey(id));
    }

    @PostMapping("addOne")
    public ResultBinder addOne(@RequestBody Area area) {
        return ResultBinderUtil.success(super.insertSelective(area));
    }

    @PostMapping("updateOne")
    public ResultBinder updateOne(@RequestBody Area area) {
        return ResultBinderUtil.success(super.updateSelective(area));
    }
}
