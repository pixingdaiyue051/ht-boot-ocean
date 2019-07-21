package com.tequeno.client.controller;

import com.tequeno.client.entity.UmUserInfo;
import com.tequeno.client.mapper.UmUserInfoMapper;
import com.tequeno.client.service.BaseServiceImpl;
import com.tequeno.common.constants.HtCommonConstant;
import com.tequeno.common.constants.ResultBinder;
import com.tequeno.common.utils.HtResultInfoWrapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Transactional
@RequestMapping("user")
public class UserController extends BaseServiceImpl<UmUserInfoMapper, UmUserInfo> {

    @PostMapping("list")
    public ResultBinder list(@RequestParam Map<String, Object> map) {
        map.put(HtCommonConstant.ORDERBY, "priority desc");
        List<UmUserInfo> list = super.getList(map);
        if (list != null && !list.isEmpty()) {
            list.forEach(item -> System.out.println(item.getTruename()));
        }
        System.out.println(list.stream().distinct().count());
        return HtResultInfoWrapper.success(list);
    }

    @PostMapping("addOne")
    public ResultBinder addOne(@RequestBody UmUserInfo userInfo) {
        return HtResultInfoWrapper.success(mapper.insertSelective(userInfo));
    }
}
