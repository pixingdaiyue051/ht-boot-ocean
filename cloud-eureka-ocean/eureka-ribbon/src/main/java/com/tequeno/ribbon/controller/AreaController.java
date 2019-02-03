package com.tequeno.ribbon.controller;

import com.tequeno.common.constants.DemoConstants;
import com.tequeno.common.utils.ResultBinder;
import com.tequeno.common.utils.ResultBinderUtil;
import com.tequeno.ribbon.entity.Area;
import com.tequeno.ribbon.entity.UmUserInfo;
import com.tequeno.ribbon.service.area.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("area")
public class AreaController extends BaseController {

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
            Area area = new Area();
            area.setAreaName("ribbon-222");
            areaService.insertSelective(area);
//            System.out.println(1 / 0);
//-------------------------------------------------------------

            UmUserInfo userInfo = new UmUserInfo();
            userInfo.setId("1221");
            userInfo.setUserName("ab111");
            userInfo.setTrueName("ab111");
            userInfo.setPwd("123456");
            ResultBinder rb = restTemplate.postForObject("http://eureka-client/user/addOne", userInfo, ResultBinder.class);
            System.out.println(rb.getMsg() + "===" + rb.getData());
            return ResultBinderUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBinderUtil.fail();
        }
    }
}
