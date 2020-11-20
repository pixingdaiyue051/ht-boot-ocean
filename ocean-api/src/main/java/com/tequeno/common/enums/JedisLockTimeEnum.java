package com.tequeno.common.enums;

/**
 * @Desription:
 * @Author: hexk
 */
public enum JedisLockTimeEnum {

    /**
     * 每2秒尝试一次，最长等待2分钟
     */
    COMMON(5 * 60 * 1000L, 2 * 1000L, 2 * 60 * 1000L),
    /**
     * 每10秒尝试一次，最长等待10分钟
     */
    SLOW(5 * 60 * 1000L, 10 * 1000L, 10 * 60 * 1000L),
    /**
     * 每秒尝试一次，最长等待一分钟
     */
    QUICK(5 * 60 * 1000L, 1000L, 60 * 1000L);

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
