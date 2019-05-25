package com.tequeno.bootssm.controller;

import com.tequeno.bootssm.mapper.area.AreaMapper;
import com.tequeno.bootssm.pojo.area.Area;
import com.tequeno.bootssm.pojo.area.AreaQuery;
import com.tequeno.bootssm.service.BaseServiceImpl;
import com.tequeno.common.utils.ResultBinder;
import com.tequeno.common.utils.ResultBinderUtil;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("area")
public class AreaController extends BaseServiceImpl<AreaMapper, Area, AreaQuery> {

    @PostMapping("list")
    public ResultBinder list(@RequestBody AreaQuery areaQ) {
//        areaQ.setLoadMethod("");
//        areaQ.setOrderBy();
        List<Area> list = super.getList(areaQ);
        if (list != null && !list.isEmpty()) {
            list.forEach(System.out::println);
        }
        System.out.println(list.stream().distinct().count());
        return ResultBinderUtil.success(list);
    }

    @GetMapping("one/{id}")
    public ResultBinder one(@PathVariable Integer id) {
        return ResultBinderUtil.success(super.selectByPrimaryKey(id));
    }

    @PostMapping("addOne")
    @Transactional
    public ResultBinder addOne(@RequestBody Area area) {
        super.insertSelective(area);
        return ResultBinderUtil.success(true);
    }

    @PostMapping("updateOne")
    @Transactional
    public ResultBinder updateOne(@RequestBody Area area) {
        super.updateSelective(area);
        return ResultBinderUtil.success(true);
    }
}