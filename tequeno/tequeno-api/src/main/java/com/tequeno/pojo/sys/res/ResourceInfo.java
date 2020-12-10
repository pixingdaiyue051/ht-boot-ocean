package com.tequeno.pojo.sys.res;

import com.tequeno.pojo.BaseEntity;

import javax.persistence.Table;

@Table(name = "um_resource_info")
public class ResourceInfo extends BaseEntity {

    private final static long serialVersionUID = 220700261847671111L;

    private Long pid;

    private String resCode;

    private String resZhName;

    private String resCnName;

    private Integer grade;

    private String resUrl;

    private Integer seq;

    private String remark;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getResZhName() {
        return resZhName;
    }

    public void setResZhName(String resZhName) {
        this.resZhName = resZhName;
    }

    public String getResCnName() {
        return resCnName;
    }

    public void setResCnName(String resCnName) {
        this.resCnName = resCnName;
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
        this.resUrl = resUrl;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}