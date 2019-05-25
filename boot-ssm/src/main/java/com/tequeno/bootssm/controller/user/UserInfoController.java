package com.tequeno.bootssm.controller.user;

import com.github.pagehelper.PageInfo;
import com.tequeno.bootssm.pojo.sys.user.UserInfo;
import com.tequeno.bootssm.pojo.sys.user.UserInfoQuery;
import com.tequeno.bootssm.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @GetMapping("index")
    public String index() {
        return "user/index";
    }

    @GetMapping("page1")
    public String page() {
        return "user/page1";
    }

    @GetMapping("page")
    public String page(Model model, UserInfoQuery userQ) {
        userQ.setPageSize(3);
        PageInfo<UserInfo> pager = userService.findPager(userQ);
        System.out.println(pager);
        if (pager.getTotal() > 0) {
            int[] navigatepageNums = pager.getNavigatepageNums();
            model.addAttribute("nums", navigatepageNums);
            model.addAttribute("userList", pager.getList());
        }
        return "user/page";
    }
}