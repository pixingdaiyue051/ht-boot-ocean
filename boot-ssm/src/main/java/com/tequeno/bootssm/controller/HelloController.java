package com.tequeno.bootssm.controller;

import com.tequeno.bootssm.pojo.area.Area;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("name", "hello");
        model.addAttribute("value", "world");
        Area a = new Area();
        a.setAreaName("thymleaf");
        model.addAttribute("area", a);
        return "index";
    }

    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "hello world!";
    }
}
