package com.tequeno.client.entity;

import javax.persistence.Table;
import java.util.Date;

@Table(name = "um_resource_info")
public class UmResourceInfo {
    private String id;

    private String pid;

    private String resZhName;

    private String resCnName;

    private Integer grade;

    private String resUrl;

    private Integer seq;

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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getResZhName() {
        return resZhName;
    }

    public void setResZhName(String resZhName) {
        this.resZhName = resZhName == null ? null : resZhName.trim();
    }

    public String getResCnName() {
        return resCnName;
    }

    public void setResCnName(String resCnName) {
        this.resCnName = resCnName == null ? null : resCnName.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl == null ? null : resUrl.trim();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
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