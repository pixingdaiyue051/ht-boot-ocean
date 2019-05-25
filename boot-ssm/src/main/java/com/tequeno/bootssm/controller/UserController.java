//package com.tequeno.bootssm.controller;
//
//import com.tequeno.bootssm.mapper.sys.UserInfoMapper;
//import com.tequeno.bootssm.pojo.sys.user.UserInfo;
//import com.tequeno.bootssm.pojo.sys.user.UserInfoQuery;
//import com.tequeno.bootssm.service.BaseServiceImpl;
//import com.tequeno.common.constants.ResultBinder;
//import com.tequeno.common.utils.CommonResultUtil;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("user")
//public class UserController extends BaseServiceImpl<UserInfoMapper, UserInfo, UserInfoQuery> {
//
//    @PostMapping("list")
//    public ResultBinder list(@RequestBody UserInfoQuery userQ) {
//        List<UserInfo> userInfoList = super.getList(userQ);
//        return CommonResultUtil.success(userInfoList);
//    }
//
//    @GetMapping("one/{id}")
//    public ResultBinder one(@PathVariable Integer id) {
//        return CommonResultUtil.success(super.selectByPrimaryKey(id));
//    }
//
//    @PostMapping("addOne")
//    @Transactional
//    public ResultBinder addOne(@RequestBody UserInfo userInfo) {
//        super.insertSelective(userInfo);
//        return CommonResultUtil.success(true);
//    }
//
//    @PostMapping("updateOne")
//    @Transactional
//    public ResultBinder updateOne(@RequestBody UserInfo userInfo) {
//        super.updateSelective(userInfo);
//        return CommonResultUtil.success(true);
//    }
//}