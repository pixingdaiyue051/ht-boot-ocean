package com.tequeno.iou.pojo.area;

import com.tequeno.iou.pojo.BaseEntity;

import javax.persistence.Table;

@Table(name = "tb_area")
public class Area extends BaseEntity {

    private String areaName;

    private Integer priority;

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

    public Area(String areaName, Integer priority) {
        this.areaName = areaName;
        this.priority = priority;
    }

}