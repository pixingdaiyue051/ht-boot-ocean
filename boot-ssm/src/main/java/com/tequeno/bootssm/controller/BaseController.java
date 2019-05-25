package com.tequeno.bootssm.controller;

import com.tequeno.config.cache.JedisCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("base")
public class BaseController {

    @Autowired
    protected JedisCacheUtil cacheUtil;
}
