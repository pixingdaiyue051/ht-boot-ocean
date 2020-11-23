package com.tequeno.iou.pojo.sys.data;

import com.tequeno.iou.pojo.BaseEntity;

import javax.persistence.Table;

@Table(name = "um_data_dictionary")
public class DataDictionary extends BaseEntity {

    private final static long serialVersionUID = -4610934219433753563L;

    private String typeCode;

    private String typeName;

    private String valueCode;

    private String valueName;

    private Integer compareValue;

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getValueCode() {
        return valueCode;
    }

    public void setValueCode(String valueCode) {
        this.valueCode = valueCode;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public Integer getCompareValue() {
        return compareValue;
    }

    public void setCompareValue(Integer compareValue) {
        this.compareValue = compareValue;
    }
}