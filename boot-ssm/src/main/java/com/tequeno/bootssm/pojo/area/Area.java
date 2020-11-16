package com.tequeno.bootssm.pojo.area;

import com.tequeno.bootssm.pojo.BaseEntity;

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

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", areaName='" + areaName + '\'' +
                ", priority=" + priority +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}