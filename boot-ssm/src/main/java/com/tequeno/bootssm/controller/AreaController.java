package com.tequeno.bootssm.controller;

import com.tequeno.common.constants.DemoConstants;
import com.tequeno.common.utils.ResultBinder;
import com.tequeno.common.utils.ResultBinderUtil;
import com.tequeno.bootssm.entity.area.Area;
import com.tequeno.bootssm.service.area.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @PostMapping("list")
    public ResultBinder list(@RequestParam Map<String, Object> map) {
        map.put(DemoConstants.ORDERBY, "priority desc");
        List<Area> list = areaService.getList(map);
        if (list != null && !list.isEmpty()) {
            list.forEach(item -> System.out.println(item.getAreaName()));
        }
        System.out.println(list.stream().distinct().count());
        return ResultBinderUtil.success(list);
    }

    @GetMapping("one/{id}")
    public ResultBinder one(@PathVariable Integer id) {
        return ResultBinderUtil.success(areaService.selectByPrimaryKey(id));
    }

    @PostMapping("add")
    public ResultBinder add(@RequestBody List<Area> areaList) {
        return ResultBinderUtil.success(areaService.insertBatch(areaList));
    }

    @PostMapping("addOne")
    public ResultBinder addOne(@RequestBody Area area) {
        return ResultBinderUtil.success(areaService.insertSelective(area));
    }

    @PostMapping("updateOne")
    public ResultBinder updateOne(@RequestBody Area area) {
        return ResultBinderUtil.success(areaService.updateSelective(area));
    }

    @DeleteMapping("delete")
    public ResultBinder delete(@RequestParam Map<String, Object> map) {
        return ResultBinderUtil.success(areaService.deleteByCondition(map));
    }

    @PostMapping("test/transcation")
    public ResultBinder test() {
        try {
            // 1、
            List<Area> list = new ArrayList<>();
            Area area = new Area();
            area.setAreaName("333");
            list.add(area);
            areaService.insertBatch(list);
            // 2、
            list = new ArrayList<>();
            area = new Area();
            area.setId("37");
            area.setAreaName("222");
            list.add(area);
            areaService.updateBatch(list);
            return ResultBinderUtil.success();
        } catch (Exception e) {
            return ResultBinderUtil.fail();
        }
    }
}
