package com.tequeno.bootssm.pojo.area;

import com.tequeno.common.constants.CommonQuery;

public class AreaQuery extends CommonQuery {

    private String areaName;

    private String areaNameLike;

    private Integer priority;

    private Integer priorityGt;

    private Integer priorityLt;

    private Integer priorityGte;

    private Integer priorityLte;

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

    public String getAreaNameLike() {
        return areaNameLike;
    }

    public void setAreaNameLike(String areaNameLike) {
        this.areaNameLike = areaNameLike;
    }
}