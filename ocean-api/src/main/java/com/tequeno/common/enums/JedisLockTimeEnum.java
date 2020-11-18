package com.tequeno.common.enums;

/**
 * @Desription:
 * @Author: hexk
 */
public enum JedisLockTimeEnum {

    COMMON(10 * 60 * 1000L, 5000L, 5 * 60 * 1000L),
    SLOW(10 * 60 * 1000L, 10000L, 10 * 60 * 1000L),
    QUICK(10 * 60 * 1000L, 1000L, 2 * 60 * 1000L);

    /**
     * redis锁过期时间
     */
    private long expireTime;

    /**
     * 重复获取锁间隔
     */
    private long retryEvicTime;

    /**
     * 最大等待时间
     */
    private long evicTime;

    JedisLockTimeEnum(long expireTime, long retryEvicTime, long evicTime) {
        this.expireTime = expireTime;
        this.retryEvicTime = retryEvicTime;
        this.evicTime = evicTime;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public long getRetryEvicTime() {
        return retryEvicTime;
    }

    public long getEvicTime() {
        return evicTime;
    }

}
