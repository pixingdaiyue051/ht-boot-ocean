//package com.tequeno.bootassembly;
//
//import com.tequeno.config.JedisUtil;
//import com.tequeno.config.RedissonUtil;
//import com.tequeno.constants.HtResultBinder;
//import com.tequeno.enums.JedisSeqPrefixEnum;
//import com.tequeno.utils.HtResultInfoWrapper;
//import org.redisson.api.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.time.LocalDateTime;
//import java.util.*;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.CopyOnWriteArrayList;
//import java.util.concurrent.TimeUnit;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
///**
// * @Desription:
// * @Author: hexk
// */
//
//@RestController
//@RequestMapping("test")
//public class JedisTestController {
//
//    private final static Logger logger = LoggerFactory.getLogger(JedisTestController.class);
//
//    @Resource
//    private JedisUtil jedisUtil;
//
//    @Resource
//    private RedissonClient redissonClient;
//
//    @Resource
//    private ThreadPoolTaskExecutor pool;
//
//    @RequestMapping("one")
//    public HtResultBinder one() {
//        String key = "TEST:_3";
//        String value = "val_";
//
//        long l1 = System.currentTimeMillis();
////        boolean result = jedisUtil.stringSetDefault(key, value);
//        String result = jedisUtil.stringGet(key);
//        long l2 = System.currentTimeMillis();
//        logger.info("redis执行[{}]ms,[{}]", l2 - l1, result);
//        return HtResultInfoWrapper.success(result);
//    }
//
//    @RequestMapping("two")
//    public HtResultBinder two() {
//        String key = "TEST:_";
//        String value = "val_";
//        String hashKey = "HTEST:VIVALAVIDA";
//        Map<String, String> map = IntStream.range(0, 1000)
//                .boxed()
//                .parallel()
//                .collect(Collectors.toMap(i -> key + i, i -> value + i));
//
//        List<String> list = IntStream.range(0, 1000)
//                .boxed()
//                .parallel()
//                .map(i -> key + i)
//                .collect(Collectors.toList());
//
//        long l1 = System.currentTimeMillis();
////        boolean result = jedisUtil.stringSetDefault(map);
////        boolean result = jedisUtil.stringDel(list);
////        boolean result = jedisUtil.hashMultiSetDefault(hashKey, map);
//        List<String> result = jedisUtil.hashMultiGet(hashKey, list);
//        long l2 = System.currentTimeMillis();
//        logger.info("redis执行[{}]ms,[{}]", l2 - l1, result);
//        return HtResultInfoWrapper.success(result);
//    }
//
//    @RequestMapping("three")
//    public HtResultBinder three() {
//        String keyPattern = "HTEST*";
//        String lockKey = "waa";
//        long l1 = System.currentTimeMillis();
//        String token = String.valueOf(l1);
////        boolean result = jedisUtil.luaTryLock(lockKey, token, JedisLockTimeEnum.COMMON.getExpireTime());
////        boolean result = jedisUtil.luaTryLock(lockKey, token, JedisLockTimeEnum.QUICK);
////        boolean result = jedisUtil.luaReleaseLock(lockKey, token);
//        String result = jedisUtil.luaGetSequenceNum(JedisSeqPrefixEnum.TEST);
////        List<String> result = jedisUtil.luaKeysByPattern(keyPattern);
////        boolean result = jedisUtil.luaDelKeysByPattern(keyPattern);
//        long l2 = System.currentTimeMillis();
//        logger.info("redis执行[{}]ms,[{}]", l2 - l1, result);
//        return HtResultInfoWrapper.success(result);
//    }
//
//    @RequestMapping("four")
//    public HtResultBinder four() throws Exception {
//        String time = jedisUtil.time();
//        System.out.println(time);
//        long l = System.currentTimeMillis();
//        System.out.println(l);
//
////        RBatch batch = redissonClient.createBatch();
////        RMapAsync<Object, Object> batchMap = batch.getMap("map:e11");
////        batchMap.fastPutAsync("dq", 221);
////        batchMap.fastPutAsync("dq1", 2212);
////        batchMap.fastPutAsync("dq112", 221212);
////        batchMap.expireAsync(1L, TimeUnit.MINUTES);
////
////        batch.getBucket("bucket:kio").trySetAsync("211", 1L, TimeUnit.MINUTES);
////        batch.getBucket("bucket:3132").trySetAsync("211", 1L, TimeUnit.MINUTES);
////        batch.getBucket("bucket:652e2").trySetAsync("211", 1L, TimeUnit.MINUTES);
////        batch.getBucket("bucket:fgf3").trySetAsync("211", 1L, TimeUnit.MINUTES);
////        batch.getBucket("bucket:gr33").trySetAsync("211", 1L, TimeUnit.MINUTES);
////        batch.getBucket("bucket:gr32443").trySetAsync("211", 1L, TimeUnit.MINUTES);
////
////        RFuture<BatchResult<?>> batchResultRFuture = batch.executeAsync();
////        BatchResult<?> batchResult = batchResultRFuture.get(1L, TimeUnit.MINUTES);
////        batchResult.getResponses().forEach(System.out::println);
//
//        RList<Object> rList = redissonClient.getList("list:lo");
//        List<Object> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
//        List<Object> arrayList = new ArrayList<>();
//
//        RMap<Object, Object> rMap = redissonClient.getMap("hash:21ko");
//        Map<Object, Object> hashMap = new HashMap<>();
//        Map<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
//
//        final String VALUE = "VALUE";
//
//        IntStream.rangeClosed(1, 9)
//                .forEach(i -> pool.execute(() -> IntStream.rangeClosed(1, 9).forEach(ii -> {
//                    int key = i * ii;
//
//                    rList.add(key);
//                    copyOnWriteArrayList.add(key);
//                    arrayList.add(key);
//
//                    rMap.put(key, VALUE);
//                    hashMap.put(key, VALUE);
//                    concurrentHashMap.put(key, VALUE);
//                })));
//
//        Thread.sleep(5000L);
//        System.out.println("-------------rList.size()" + rList.size());
//        rList.forEach(System.out::println);
//        System.out.println("-------------copyOnWriteArrayList.size()" + copyOnWriteArrayList.size());
//        copyOnWriteArrayList.forEach(System.out::println);
//        System.out.println("-------------arrayList.size()" + arrayList.size());
//        arrayList.forEach(System.out::println);
//        System.out.println("-------------rMap.size()" + rMap.size());
//        rMap.forEach((k, v) -> System.out.println(k));
//        System.out.println("-------------hashMap.size()" + hashMap.size());
//        hashMap.forEach((k, v) -> System.out.println(k));
//        System.out.println("-------------concurrentHashMap.size()" + concurrentHashMap.size());
//        concurrentHashMap.forEach((k, v) -> System.out.println(k));
//
//        return HtResultInfoWrapper.success(true);
//    }
//
//}
