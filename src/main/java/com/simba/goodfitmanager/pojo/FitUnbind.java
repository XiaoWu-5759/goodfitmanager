package com.simba.goodfitmanager.pojo;

import java.util.Date;

public class FitUnbind {
    private String icid;

    private Date relieveTime;

    private String relieveCar;

    public String getIcid() {
        return icid;
    }

    public void setIcid(String icid) {
        this.icid = icid;
    }

    public Date getRelieveTime() {
        return relieveTime;
    }

    public void setRelieveTime(Date relieveTime) {
        this.relieveTime = relieveTime;
    }

    public String getRelieveCar() {
        return relieveCar;
    }

    public void setRelieveCar(String relieveCar) {
        this.relieveCar = relieveCar;
    }

    public FitUnbind() {
    }

    public FitUnbind(String icid, Date relieveTime, String relieveCar) {
        this.icid = icid;
        this.relieveTime = relieveTime;
        this.relieveCar = relieveCar;
    }
}