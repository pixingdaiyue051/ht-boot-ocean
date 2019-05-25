package com.tequeno.bootssm.controller.user;

import com.tequeno.bootssm.mapper.sys.UserInfoMapper;
import com.tequeno.bootssm.pojo.sys.user.UserInfo;
import com.tequeno.bootssm.pojo.sys.user.UserInfoQuery;
import com.tequeno.bootssm.service.BaseServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserInfoController extends BaseServiceImpl<UserInfoMapper, UserInfo, UserInfoQuery> {

    @GetMapping("index")
    public String index(){
        return "user/index";
    }
}