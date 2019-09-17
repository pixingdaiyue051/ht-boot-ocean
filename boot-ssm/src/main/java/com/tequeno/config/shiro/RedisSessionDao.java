package com.tequeno.config.shiro;

import com.tequeno.common.constants.HtPropertyConstant;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class RedisSessionDao extends EnterpriseCacheSessionDAO {

    private final long SESSION_TIMEOUT = HtPropertyConstant.SESSION_TIMEOUT;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = super.doCreate(session);
        String sessionKey = JedisKeyPrefixEnum.SESSION.assemblyKey(sessionId);
        redisTemplate.opsForValue().set(sessionKey, session, SESSION_TIMEOUT, TimeUnit.SECONDS);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        Session session = super.doReadSession(sessionId);
        if (null == session) {
            String sessionKey = JedisKeyPrefixEnum.SESSION.assemblyKey(sessionId);
            session = (Session) redisTemplate.opsForValue().get(sessionKey);
        }
        return session;
    }

    @Override
    protected void doUpdate(Session session) {
        super.doUpdate(session);
        String sessionKey = JedisKeyPrefixEnum.SESSION.assemblyKey(session.getId());
        redisTemplate.expire(sessionKey, SESSION_TIMEOUT, TimeUnit.SECONDS);
    }

    @Override
    protected void doDelete(Session session) {
        super.doDelete(session);
        String sessionKey = JedisKeyPrefixEnum.SESSION.assemblyKey(session.getId());
        redisTemplate.delete(sessionKey);
    }

    @Override
    public Collection<Session> getActiveSessions() {
        return super.getActiveSessions();
    }
}