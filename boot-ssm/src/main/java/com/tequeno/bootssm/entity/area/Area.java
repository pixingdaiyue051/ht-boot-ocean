package com.tequeno.bootssm.entity.area;

import com.tequeno.bootssm.entity.BaseEntity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tb_area")
public class Area extends BaseEntity {

    private String AreaName;

    private Integer priority;

    public Area() {
    }

    public String getAreaName() {
        return AreaName;
    }

    public void setAreaName(String areaName) {
        AreaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", AreaName='" + AreaName + '\'' +
                ", priority=" + priority +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
