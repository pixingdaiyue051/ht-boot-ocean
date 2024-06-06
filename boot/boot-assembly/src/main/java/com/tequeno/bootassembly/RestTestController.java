package com.tequeno.bootassembly;

import com.tequeno.constants.HtResultBinder;
import com.tequeno.utils.HtResultInfoWrapper;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

@RestController
@RequestMapping("test/rest")
public class RestTestController {

    @Resource
    private ThreadPoolTaskExecutor threadPool;

    @Resource
    private RestTemplate restTemplate;

    /**
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("run")
    public HtResultBinder run() throws InterruptedException {
        int threadSize = 20;
        String url = "http://127.0.0.1:7210/test/jedis/seq";
        CountDownLatch c = new CountDownLatch(threadSize);
        IntStream.range(0, threadSize).forEach(i -> {
            threadPool.execute(() -> post(url));
            c.countDown();
        });
        c.wait();
        return HtResultInfoWrapper.success();
    }

    private void post(String url) {
//        // 接口请求参数
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//        map.put("prisonId", ImmutableList.of(String.valueOf(prisonId)));
//        map.put("pageNow", ImmutableList.of(String.valueOf(pageNow)));
//        map.put("pageSize", ImmutableList.of(String.valueOf(pageSize)));
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        restTemplate.postForObject(url, null, String.class);

    }
}