package com.tequeno.enums;

public enum JedisLuaScriptEnum {
    TRY_LOCK("luaTryLock", "try_lock.lua"),
    RELEASE_LOCK("luaReleaseLock", "release_lock.lua"),
    SEQUENCE_NUM("luaGetSequenceNum", "sequence_num.lua"),
    KEYS_PATTERN("luaKeysByPattern", "keys_pattern.lua"),
    DEL_KEYS_PATTERN("luaDelKeysByPattern", "del_keys_pattern.lua"),
    ;
    private final String scriptName;
    private final String luaFileName;

    JedisLuaScriptEnum(String scriptName, String luaFileName) {
        this.scriptName = scriptName;
        this.luaFileName = luaFileName;
    }

    public String getScriptName() {
        return scriptName;
    }

    public String getLuaFileName() {
        return luaFileName;
    }
}