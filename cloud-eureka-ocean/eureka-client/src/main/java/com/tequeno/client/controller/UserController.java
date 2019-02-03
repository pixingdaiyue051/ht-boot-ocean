package com.tequeno.client.controller;

import com.tequeno.client.entity.UmUserInfo;
import com.tequeno.client.service.user.UserInfoService;
import com.tequeno.common.constants.DemoConstants;
import com.tequeno.common.utils.ResultBinder;
import com.tequeno.common.utils.ResultBinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("list")
    public ResultBinder list(@RequestParam Map<String, Object> map) {
        map.put(DemoConstants.ORDERBY, "priority desc");
        List<UmUserInfo> list = userInfoService.getList(map);
        if (list != null && !list.isEmpty()) {
            list.forEach(item -> System.out.println(item.getTrueName()));
        }
        System.out.println(list.stream().distinct().count());
        return ResultBinderUtil.success(list);
    }

    @PostMapping("addOne")
    public ResultBinder addOne(@RequestBody UmUserInfo userInfo) {
        return ResultBinderUtil.success(userInfoService.insertSelective(userInfo));
    }

    @PostMapping("updateOne")
    public ResultBinder updateOne(@RequestBody UmUserInfo userInfo) {
        return ResultBinderUtil.success(userInfoService.updateSelective(userInfo));
    }

}
