package com.tequeno.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Desription:
 * @Author: hexk
 */
@Component
public class JedisUtil {

    @Autowired
    private JedisPool jedisPool;

    public String get(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisPool.returnResource(jedis);
        }
        return null;
    }
}
