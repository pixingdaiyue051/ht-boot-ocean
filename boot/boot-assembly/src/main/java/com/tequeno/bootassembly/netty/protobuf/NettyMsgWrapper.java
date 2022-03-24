package com.tequeno.bootassembly.netty.protobuf;

public class NettyMsgWrapper {

    public static Wrapper wrap(String code, String msg) {
        return Wrapper.newBuilder()
                .setDataType(Wrapper.DataType.REQ)
                .setCode(code)
                .setMsg(msg)
                .build();
    }
}
