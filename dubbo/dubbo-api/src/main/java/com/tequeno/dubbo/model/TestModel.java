package com.tequeno.dubbo.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Desription:
 * @Author: hexk
 */
public class TestModel implements Serializable {

    private final static long serialVersionUID = -1414180066170446366L;

    private Byte aByte;
    private Short aShort;
    private Integer aInt;
    private Long aLong;
    private Float aFloat;
    private Double aDouble;
    private Character aChar;
    private Boolean aBoolean;
    private String str;
    private List<String> list;
    private Map<String, String> map;

    public Byte getaByte() {
        return aByte;
    }

    public void setaByte(Byte aByte) {
        this.aByte = aByte;
    }

    public Short getaShort() {
        return aShort;
    }

    public void setaShort(Short aShort) {
        this.aShort = aShort;
    }

    public Integer getaInt() {
        return aInt;
    }

    public void setaInt(Integer aInt) {
        this.aInt = aInt;
    }

    public Long getaLong() {
        return aLong;
    }

    public void setaLong(Long aLong) {
        this.aLong = aLong;
    }

    public Float getaFloat() {
        return aFloat;
    }

    public void setaFloat(Float aFloat) {
        this.aFloat = aFloat;
    }

    public Double getaDouble() {
        return aDouble;
    }

    public void setaDouble(Double aDouble) {
        this.aDouble = aDouble;
    }

    public Character getaChar() {
        return aChar;
    }

    public void setaChar(Character aChar) {
        this.aChar = aChar;
    }

    public Boolean getaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
