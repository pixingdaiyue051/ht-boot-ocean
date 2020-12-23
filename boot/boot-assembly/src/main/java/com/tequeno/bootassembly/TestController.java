package com.tequeno.bootassembly;

import com.tequeno.common.constants.HtResultBinder;
import com.tequeno.common.utils.HtResultInfoWrapper;
import com.tequeno.config.redis.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desription:
 * @Author: hexk
 */

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private JedisUtil jedisUtil;

    /**
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("one")
    public HtResultBinder one(@RequestParam String key,
                              @RequestParam String value,
                              @RequestParam List<File> fileList) {
        try {
            System.out.println(URLDecoder.decode(key, "UTF-8"));
            System.out.println(URLDecoder.decode(value, "UTF-8"));
            fileList.forEach(f -> System.out.println(f.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HtResultInfoWrapper.success();
    }

    /**
     * @return
     */
    @RequestMapping("two")
    public HtResultBinder two() {
        boolean isOk = jedisUtil.tryLock("eed", 100000L);
        if (isOk) {
            jedisUtil.hset("H:DE", "sd", "da", 30000L);
            Map<String, String> map = new HashMap<>(11);
            map.put("1a", "1a");
            map.put("2a", "2a");
            map.put("3a", "3a");
            map.put("4a", "4a");
            map.put("5a", "5a");
            map.put("6a", "6a");
            jedisUtil.hmset("H:FD", map);
            List<String> list = jedisUtil.hmget("H:FD");
            return HtResultInfoWrapper.success(list);
        }
        return HtResultInfoWrapper.success(isOk);
    }
}
