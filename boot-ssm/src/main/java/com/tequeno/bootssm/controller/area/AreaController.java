package com.tequeno.bootssm.controller.area;

import com.tequeno.bootssm.pojo.area.Area;
import com.tequeno.bootssm.pojo.area.AreaQuery;
import com.tequeno.bootssm.service.area.AreaService;
import com.tequeno.common.constants.ResultBinder;
import com.tequeno.common.utils.HtResultInfoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping("list")
    public ResultBinder list(@RequestBody AreaQuery areaQ) {
        List<Area> list = areaService.getList(areaQ);
        return HtResultInfoWrapper.success(list);
    }

    @RequestMapping("one/{id}")
    public ResultBinder one(@PathVariable Integer id) {
        return HtResultInfoWrapper.success(areaService.selectByPrimaryKey(id));
    }

    @RequestMapping("addOne")
    @Transactional(rollbackFor = Exception.class)
    public ResultBinder addOne(@RequestBody Area area) {
        areaService.insertSelective(area);
        return HtResultInfoWrapper.success();
    }

    @RequestMapping("updateOne")
    @Transactional(rollbackFor = Exception.class)
    public ResultBinder updateOne(@RequestBody Area area) {
        areaService.updateSelective(area);
        return HtResultInfoWrapper.success();
    }
}