package com.webmovieticket.dto;

public class SeatsDTO {

    private Long seat_id;

    private String seat_name;

    private String td_id;

    public Long getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(Long seat_id) {
        this.seat_id = seat_id;
    }

    public String getSeat_name() {
        return seat_name;
    }

    public void setSeat_name(String seat_name) {
        this.seat_name = seat_name;
    }

    public String getTd_id() {
        return td_id;
    }

    public void setTd_id(String td_id) {
        this.td_id = td_id;
    }
}
