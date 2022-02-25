package com.tequeno.bootassembly.netty;

import io.netty.util.AttributeKey;

/**
 * @author PC
 * @since 2020/12/4 15:39
 */
public final class NettyConstant {

    public final static int PORT = 7132;

    public final static int WRITER_IDLE_TIME = 30;

    public final static int READER_IDLE_TIME = 60;

    public final static int MAX_IDLE_TIMES = 5;

    public final static AttributeKey<Object> ATTR_READ_IDLE = AttributeKey.valueOf(NettyKeyEnum.READ_IDLE.getKey());

    public final static AttributeKey<Object> ATTR_CHANNEL_INACTIVE = AttributeKey.valueOf(NettyKeyEnum.CHANNEL_INACTIVE.getKey());
}