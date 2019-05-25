package com.tequeno.bootssm.pojo;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

public class BaseEntity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -8415182066150496366L;

    @Id
    protected String id;

    protected LocalDateTime createTime;

    protected LocalDateTime modifyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }
}