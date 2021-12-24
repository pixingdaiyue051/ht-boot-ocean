package com.tequeno.bootassembly.ws;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum WebSocketKeyEnum {

    DEMO("demo", "测试用"),
    CALL_APPLY("call_apply", "拨打确认"),
    AI_PUSH("ai_push", "敏感词提醒,陌生人闯入提醒"),

    IM_SERVICE("im_service", "im客服channel标志"),
    IM_USER("im_user", "im客户channel标志"),
    ;
    private final String key;

    private final String desc;

    WebSocketKeyEnum(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public static Map<String, String> map() {
        return WebSocketKeyHolder.map;
    }

    private static class WebSocketKeyHolder {
        private final static Map<String, String> map = new HashMap<>(11);

        static {
            Arrays.stream(WebSocketKeyEnum.values()).forEach(item -> map.put(item.key, item.desc));
        }
    }
}
