// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: NettyMsg.proto

package com.tequeno.bootassembly.netty.protobuf;

public interface WrapperOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Wrapper)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 设置数据的类型 方便得到数据后根据类型判断 非必要
   * </pre>
   *
   * <code>.Wrapper.DataType dataType = 1;</code>
   * @return The enum numeric value on the wire for dataType.
   */
  int getDataTypeValue();
  /**
   * <pre>
   * 设置数据的类型 方便得到数据后根据类型判断 非必要
   * </pre>
   *
   * <code>.Wrapper.DataType dataType = 1;</code>
   * @return The dataType.
   */
  com.tequeno.bootassembly.netty.protobuf.Wrapper.DataType getDataType();

  /**
   * <code>string code = 2;</code>
   * @return The code.
   */
  java.lang.String getCode();
  /**
   * <code>string code = 2;</code>
   * @return The bytes for code.
   */
  com.google.protobuf.ByteString
      getCodeBytes();

  /**
   * <code>string msg = 3;</code>
   * @return The msg.
   */
  java.lang.String getMsg();
  /**
   * <code>string msg = 3;</code>
   * @return The bytes for msg.
   */
  com.google.protobuf.ByteString
      getMsgBytes();

  /**
   * <code>.Request req = 4;</code>
   * @return Whether the req field is set.
   */
  boolean hasReq();
  /**
   * <code>.Request req = 4;</code>
   * @return The req.
   */
  com.tequeno.bootassembly.netty.protobuf.Request getReq();
  /**
   * <code>.Request req = 4;</code>
   */
  com.tequeno.bootassembly.netty.protobuf.RequestOrBuilder getReqOrBuilder();

  /**
   * <code>.Response res = 5;</code>
   * @return Whether the res field is set.
   */
  boolean hasRes();
  /**
   * <code>.Response res = 5;</code>
   * @return The res.
   */
  com.tequeno.bootassembly.netty.protobuf.Response getRes();
  /**
   * <code>.Response res = 5;</code>
   */
  com.tequeno.bootassembly.netty.protobuf.ResponseOrBuilder getResOrBuilder();

  /**
   * <pre>
   * 集合
   * </pre>
   *
   * <code>repeated .Request requestList = 6;</code>
   */
  java.util.List<com.tequeno.bootassembly.netty.protobuf.Request> 
      getRequestListList();
  /**
   * <pre>
   * 集合
   * </pre>
   *
   * <code>repeated .Request requestList = 6;</code>
   */
  com.tequeno.bootassembly.netty.protobuf.Request getRequestList(int index);
  /**
   * <pre>
   * 集合
   * </pre>
   *
   * <code>repeated .Request requestList = 6;</code>
   */
  int getRequestListCount();
  /**
   * <pre>
   * 集合
   * </pre>
   *
   * <code>repeated .Request requestList = 6;</code>
   */
  java.util.List<? extends com.tequeno.bootassembly.netty.protobuf.RequestOrBuilder> 
      getRequestListOrBuilderList();
  /**
   * <pre>
   * 集合
   * </pre>
   *
   * <code>repeated .Request requestList = 6;</code>
   */
  com.tequeno.bootassembly.netty.protobuf.RequestOrBuilder getRequestListOrBuilder(
      int index);

  public com.tequeno.bootassembly.netty.protobuf.Wrapper.DataBodyCase getDataBodyCase();
}
