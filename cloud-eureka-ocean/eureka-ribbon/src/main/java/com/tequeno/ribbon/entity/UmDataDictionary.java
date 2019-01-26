package com.tequeno.ribbon.entity;

import javax.persistence.Table;
import java.util.Date;


@Table(name = "um_data_dictionary")
public class UmDataDictionary {
    private String id;

    private String typeCode;

    private String typeName;

    private String valueCode;

    private String valueName;

    private Integer compareValue;

    private String createById;

    private String modifyById;

    private Date createTime;

    private Date modifyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getValueCode() {
        return valueCode;
    }

    public void setValueCode(String valueCode) {
        this.valueCode = valueCode == null ? null : valueCode.trim();
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName == null ? null : valueName.trim();
    }

    public Integer getCompareValue() {
        return compareValue;
    }

    public void setCompareValue(Integer compareValue) {
        this.compareValue = compareValue;
    }

    public String getCreateById() {
        return createById;
    }

    public void setCreateById(String createById) {
        this.createById = createById == null ? null : createById.trim();
    }

    public String getModifyById() {
        return modifyById;
    }

    public void setModifyById(String modifyById) {
        this.modifyById = modifyById == null ? null : modifyById.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}