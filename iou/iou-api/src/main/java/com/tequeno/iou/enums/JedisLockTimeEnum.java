package com.tequeno.iou.enums;

/**
 * @Desription:
 * @Author: hexk
 */
public enum JedisLockTimeEnum {

    /**
     * 每秒尝试一次，最长等待1分钟
     */
    QUICK(5 * 60 * 1000L, 1000L, 60 * 1000L),
    /**
     * 每5秒尝试一次，最长等待1分钟
     */
    SLOW(5 * 60 * 1000L, 5 * 1000L, 60 * 1000L),
    /**
     * 每3秒尝试一次，最长等待1分钟
     */
    COMMON(5 * 60 * 1000L, 3000L, 60 * 1000L);

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
