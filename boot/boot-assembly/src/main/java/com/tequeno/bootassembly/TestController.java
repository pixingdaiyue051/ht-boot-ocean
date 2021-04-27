package com.tequeno.bootassembly;

import com.tequeno.config.JedisUtil;
import com.tequeno.constants.HtResultBinder;
import com.tequeno.enums.JedisSeqPrefixEnum;
import com.tequeno.utils.HtResultInfoWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Desription:
 * @Author: hexk
 */

@RestController
@RequestMapping("test")
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    private JedisUtil jedisUtil;

    @RequestMapping("one")
    public HtResultBinder one() {
        String key = "TEST:_3";
        String value = "val_";

        long l1 = System.currentTimeMillis();
//        boolean result = jedisUtil.stringSetDefault(key, value);
        String result = jedisUtil.stringGet(key);
        long l2 = System.currentTimeMillis();
        logger.info("redis执行[{}]ms,[{}]", l2 - l1, result);
        return HtResultInfoWrapper.success(result);
    }

    @RequestMapping("two")
    public HtResultBinder two() {
        String key = "TEST:_";
        String value = "val_";
        String hashKey = "HTEST:VIVALAVIDA";
        Map<String, String> map = IntStream.range(0, 1000)
                .boxed()
                .parallel()
                .collect(Collectors.toMap(i -> key + i, i -> value + i));

        List<String> list = IntStream.range(0, 1000)
                .boxed()
                .parallel()
                .map(i -> key + i)
                .collect(Collectors.toList());

        long l1 = System.currentTimeMillis();
//        boolean result = jedisUtil.stringSetDefault(map);
//        boolean result = jedisUtil.stringDel(list);
//        boolean result = jedisUtil.hashMultiSetDefault(hashKey, map);
        List<String> result = jedisUtil.hashMultiGet(hashKey, list);
        long l2 = System.currentTimeMillis();
        logger.info("redis执行[{}]ms,[{}]", l2 - l1, result);
        return HtResultInfoWrapper.success(result);
    }

    @RequestMapping("three")
    public HtResultBinder three() {
        String keyPattern = "HTEST*";
        String lockKey = "waa";
        long l1 = System.currentTimeMillis();
        String token = String.valueOf(l1);
//        boolean result = jedisUtil.luaTryLock(lockKey, token, JedisLockTimeEnum.COMMON.getExpireTime());
//        boolean result = jedisUtil.luaTryLock(lockKey, token, JedisLockTimeEnum.QUICK);
//        boolean result = jedisUtil.luaReleaseLock(lockKey, token);
        String result = jedisUtil.luaGetSequenceNum(JedisSeqPrefixEnum.TEST);
//        List<String> result = jedisUtil.luaKeysByPattern(keyPattern);
//        boolean result = jedisUtil.luaDelKeysByPattern(keyPattern);
        long l2 = System.currentTimeMillis();
        logger.info("redis执行[{}]ms,[{}]", l2 - l1, result);
//        DigestUtils.sha256Hex()
        return HtResultInfoWrapper.success(result);
    }

}
