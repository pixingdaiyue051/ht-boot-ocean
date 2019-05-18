package com.tequeno.bootssm.controller;

import com.tequeno.bootssm.pojo.area.Area;
import com.tequeno.bootssm.pojo.area.AreaQuery;
import com.tequeno.bootssm.service.area.AreaService;
import com.tequeno.common.utils.ResultBinder;
import com.tequeno.common.utils.ResultBinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @PostMapping("list")
    public ResultBinder list(@RequestBody AreaQuery areaQ) {
//        areaQ.setLoadMethod("");
//        areaQ.setOrderBy();
        List<Area> list = areaService.getList(areaQ);
        if (list != null && !list.isEmpty()) {
            list.forEach(System.out::println);
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
        areaService.insertBatch(areaList);
        return ResultBinderUtil.success(true);
    }

    @PostMapping("addOne")
    public ResultBinder addOne(@RequestBody Area area) {
        areaService.insertSelective(area);
        return ResultBinderUtil.success(true);
    }

    @PostMapping("updateOne")
    public ResultBinder updateOne(@RequestBody Area area) {
        areaService.updateSelective(area);
        return ResultBinderUtil.success(true);
    }

    @DeleteMapping("delete")
    public ResultBinder delete() {
        AreaQuery areaQ = new AreaQuery();
        areaService.deleteByCondition(areaQ);
        return ResultBinderUtil.success();
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
