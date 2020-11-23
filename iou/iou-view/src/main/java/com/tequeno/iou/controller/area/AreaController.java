package com.tequeno.iou.controller.area;

import com.tequeno.iou.constants.HtResultBinder;
import com.tequeno.iou.pojo.area.Area;
import com.tequeno.iou.pojo.area.AreaQuery;
import com.tequeno.iou.service.area.AreaService;
import com.tequeno.iou.utils.HtResultInfoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping("list")
    public HtResultBinder list(@RequestBody AreaQuery areaQuery) {
        List<Area> list = areaService.getList(areaQuery);
        return HtResultInfoWrapper.success(list);
    }

    @RequestMapping("one/{id}")
    public HtResultBinder one(@PathVariable Integer id) {
        return HtResultInfoWrapper.success(areaService.selectByPrimaryKey(id));
    }

    @RequestMapping("addOne")
    public HtResultBinder addOne(@RequestBody Area area) {
        areaService.insertSelective(area);
        return HtResultInfoWrapper.success();
    }

    @RequestMapping("updateOne")
    public HtResultBinder updateOne(@RequestBody Area area) {
        areaService.updateSelective(area);
        return HtResultInfoWrapper.success();
    }
}