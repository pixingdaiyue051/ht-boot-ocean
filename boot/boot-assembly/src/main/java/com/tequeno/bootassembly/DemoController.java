package com.tequeno.bootassembly;

import com.tequeno.config.redis.RedisUtil;
import com.tequeno.constants.HtResultBinder;
import com.tequeno.utils.HtDateUtil;
import com.tequeno.utils.HtResultInfoWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("demo")
public class DemoController {

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("time")
    public HtResultBinder time() {
        String timeMillis = String.valueOf(System.currentTimeMillis());
        String javaTime = HtDateUtil.now();
        String redisTime = redisUtil.time();
        Map<String, String> map = new HashMap<>();
        map.put("timeMillis", timeMillis);
        map.put("javaTime", javaTime);
        map.put("redisTime", redisTime);
        return HtResultInfoWrapper.success(map);
    }
}