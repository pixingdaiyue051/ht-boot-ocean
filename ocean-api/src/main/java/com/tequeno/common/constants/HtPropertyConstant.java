package com.tequeno.common.constants;

public class HtPropertyConstant {

    /**
     * 数字字符串，应用于获取随机数验证码
     */
    public final static String NUMBER_STR = "0123456789";

    /**
     * 验证码长度
     */
    public final static int OTP_LENGTH = 6;

    /**
     * 验证码失效时间 60*10=10min
     */
    public final static long OTP_EXPIRED = 600L;

    /**
     * session超时时间 60*30=30min
     */
    public final static long SESSION_TIMEOUT = 1800L;

    /**
     * redis key默认超时时间 60*60*24*180=180day
     */
    public final static long DEFAULT_REDIS_KEY_TIMEOUT = 15552000L;

    /**
     * 默认管理的session名称 区别于容器默认session名
     */
    public final static String DEFAULT_SESSION_NAME = "redSessionId";

    /**
     * rememberme cookie 名称
     */
    public final static String DEFAULT_REMEMBERME_NAME = "rememberMe";

    /**
     * rememberme cookie 最长缓存时间 60*60*24*30=30day
     */
    public final static int DEFAULT_REMEMBERME_COOKIE_TIMEOUT = 2592000;

    /**
     * rememberme 默认 cipher key
     */
    public final static String DEFAULT_CIPHER_KEY = "4AvVhmFLUs0KTA3Kprsdag==";
}
