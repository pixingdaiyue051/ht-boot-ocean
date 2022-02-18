package com.tequeno.bootassembly.netty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum NettyCodeEnum {

    SUCCESS("1000", "成功"),
    FAIL("1100", "失败"),
    EXCEPTION("1101", "异常"),

    HEART("2000", "心跳包"),
    SUB("2001", "订阅包"),
    BIZ("2002", "业务包"),
    ;
    private final String code;

    private final String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    NettyCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static Map<String, String> map() {
        return NettyCodeEnum.NettyCodeHolder.map;
    }

    public static NettyCodeEnum fetch(String key) {
        return NettyCodeEnum.NettyCodeHolder.map1.get(key);
    }

    private static class NettyCodeHolder {
        private final static Map<String, String> map = new HashMap<>(11);
        private final static Map<String, NettyCodeEnum> map1 = new HashMap<>(11);

        static {
            Arrays.stream(NettyCodeEnum.values()).forEach(item -> {
                map.put(item.code, item.desc);
                map1.put(item.code, item);
            });
        }
    }
}
