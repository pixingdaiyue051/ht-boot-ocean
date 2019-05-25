package com.tequeno;

import com.tequeno.bootssm.mapper.sys.UserInfoMapper;
import com.tequeno.bootssm.pojo.sys.user.UserInfo;
import com.tequeno.bootssm.pojo.sys.user.UserInfoQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@Controller
public class BootSsmApplication {

    @Autowired
    private UserInfoMapper mapper;

    public static void main(String[] args) {
        SpringApplication.run(BootSsmApplication.class, args);
    }

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("name", "hello");
        model.addAttribute("value", "world");
        UserInfo user = new UserInfo();
        user.setUserName("aaa");
        user.setTrueName("kill me softly");
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("hello")
    public String hello(HttpServletRequest request, Model model) {
        String userName = request.getParameter("userName");
        UserInfoQuery userQ = new UserInfoQuery();
        userQ.setUserName(userName);
        List<UserInfo> userInfos = mapper.selectAllByCondition(userQ);
        Optional<LocalDateTime> date = userInfos.stream().findFirst().map(u -> u.getCreateTime());
        String format = date.orElseGet(() -> LocalDateTime.now()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        model.addAttribute("createTime", format);
        return "hello";

    }

}