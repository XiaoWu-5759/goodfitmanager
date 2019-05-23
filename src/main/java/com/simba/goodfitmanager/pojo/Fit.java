package com.simba.goodfitmanager.pojo;

import java.util.Date;

public class Fit {
    private String icid;

    private Integer type;

    private Date createTime;

    private Date activeTime;

    private Integer isActive;

    private Integer isBad;

    public String getIcid() {
        return icid;
    }

    public void setIcid(String icid) {
        this.icid = icid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getIsBad() {
        return isBad;
    }

    public void setIsBad(Integer isBad) {
        this.isBad = isBad;
    }
}