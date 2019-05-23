package com.simba.goodfitmanager.pojo;

import java.util.Date;

public class FitChange {
    private String oldIcid;

    private String newIcid;

    private Date changeTime;

    private Integer c4sId;

    public String getOldIcid() {
        return oldIcid;
    }

    public void setOldIcid(String oldIcid) {
        this.oldIcid = oldIcid;
    }

    public String getNewIcid() {
        return newIcid;
    }

    public void setNewIcid(String newIcid) {
        this.newIcid = newIcid;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public Integer getC4sId() {
        return c4sId;
    }

    public void setC4sId(Integer c4sId) {
        this.c4sId = c4sId;
    }
}