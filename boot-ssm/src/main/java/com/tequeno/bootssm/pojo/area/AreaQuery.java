package com.tequeno.bootssm.pojo.area;

import com.tequeno.bootssm.pojo.CommonQuery;

import java.util.Date;

public class AreaQuery extends CommonQuery {

    private String areaName;

    private Integer priority;

    private Integer priorityGt;

    private Integer priorityLt;

    private Integer priorityGte;

    private Integer priorityLte;

    private Date createTime;

    private Date modifyTime;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getPriorityGt() {
        return priorityGt;
    }

    public void setPriorityGt(Integer priorityGt) {
        this.priorityGt = priorityGt;
    }

    public Integer getPriorityLt() {
        return priorityLt;
    }

    public void setPriorityLt(Integer priorityLt) {
        this.priorityLt = priorityLt;
    }

    public Integer getPriorityGte() {
        return priorityGte;
    }

    public void setPriorityGte(Integer priorityGte) {
        this.priorityGte = priorityGte;
    }

    public Integer getPriorityLte() {
        return priorityLte;
    }

    public void setPriorityLte(Integer priorityLte) {
        this.priorityLte = priorityLte;
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
