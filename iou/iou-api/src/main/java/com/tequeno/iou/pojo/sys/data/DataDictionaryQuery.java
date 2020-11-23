package com.tequeno.iou.pojo.sys.data;

import com.tequeno.iou.constants.HtCommonQuery;

public class DataDictionaryQuery extends HtCommonQuery {

    private String typeCode;

    private String valueCode;

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getValueCode() {
        return valueCode;
    }

    public void setValueCode(String valueCode) {
        this.valueCode = valueCode;
    }
}