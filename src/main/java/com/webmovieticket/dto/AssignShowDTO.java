package com.webmovieticket.dto;

import java.util.Date;

public class AssignShowDTO {
    private Long show_id;

    private String morning;

    private String matney;

    private String firstShow;

    private String secondShow;

    private Date addShowDate;

    private Date toDate;

    public Long getShow_id() {
        return show_id;
    }

    public void setShow_id(Long show_id) {
        this.show_id = show_id;
    }

    public String getMorning() {
        return morning;
    }

    public void setMorning(String morning) {
        this.morning = morning;
    }

    public String getMatney() {
        return matney;
    }

    public void setMatney(String matney) {
        this.matney = matney;
    }

    public String getFirstShow() {
        return firstShow;
    }

    public void setFirstShow(String firstShow) {
        this.firstShow = firstShow;
    }

    public String getSecondShow() {
        return secondShow;
    }

    public void setSecondShow(String secondShow) {
        this.secondShow = secondShow;
    }

    public Date getAddShowDate() {
        return addShowDate;
    }

    public void setAddShowDate(Date addShowDate) {
        this.addShowDate = addShowDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
