package com.tequeno.bootssm.controller.user;

import com.tequeno.bootssm.enums.BussinessEnum;
import com.tequeno.bootssm.mapper.sys.UserInfoMapper;
import com.tequeno.bootssm.pojo.sys.user.UserInfo;
import com.tequeno.bootssm.pojo.sys.user.UserInfoQuery;
import com.tequeno.bootssm.service.BaseServiceImpl;
import com.tequeno.common.constants.ResultBinder;
import com.tequeno.common.utils.CommonException;
import com.tequeno.common.utils.CommonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserBussinessController extends BaseServiceImpl<UserInfoMapper, UserInfo, UserInfoQuery> {

    @Autowired
    private HttpServletRequest request;

    @PostMapping("list")
    public ResultBinder list(@RequestBody UserInfoQuery userQ) {
        List<UserInfo> userInfoList = super.getList(userQ);
        if (CollectionUtils.isEmpty(userInfoList)) {
            return CommonResultUtil.fail(BussinessEnum.USER_NOT_EXIST);
        }
        return CommonResultUtil.success(userInfoList);
    }

    @GetMapping("one/{id}")
    public ResultBinder one(@PathVariable Integer id) {
        UserInfo userInfo = super.selectByPrimaryKey(id);
        if (null == userInfo) {
            throw new CommonException(BussinessEnum.USER_NOT_EXIST);
        }
        return CommonResultUtil.success(userInfo);
    }

    @PostMapping("addOne")
    @Transactional
    public ResultBinder addOne(@RequestBody UserInfo userInfo) {
        super.insertSelective(userInfo);
        return CommonResultUtil.success(true);
    }

    @PostMapping("updateOne")
    @Transactional
    public ResultBinder updateOne(@RequestBody UserInfo userInfo) {
        super.updateSelective(userInfo);
        return CommonResultUtil.success(true);
    }

    @PostMapping("opt")
    public ResultBinder getOpt(@RequestParam("tel") String tel) {
        HttpSession session = request.getSession();
        String optCode = getNonceStr();
        session.setAttribute(tel, optCode);
        return CommonResultUtil.success(optCode);
    }

    private String getNonceStr() {
        final String SYMBOLS = "0123456789";
//        final String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final char[] nonceChars = new char[4];
        final Random random = new Random();
        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = SYMBOLS.charAt(random.nextInt(SYMBOLS.length()));
        }
        return new String(nonceChars);
    }
}