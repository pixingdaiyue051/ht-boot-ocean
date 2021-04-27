package com.tequeno.controller.area;

import com.tequeno.constants.HtResultBinder;
import com.tequeno.pojo.area.Area;
import com.tequeno.pojo.area.AreaQuery;
import com.tequeno.service.area.AreaService;
import com.tequeno.utils.HtResultInfoWrapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("area")
public class AreaController {

    @Resource
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