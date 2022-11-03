package com.webmovieticket.dto;

public class ChargesDTO {

    private Long charge_id;

    private String td_id;

    private String seat_name;

    private String charges;

    public Long getCharge_id() {
        return charge_id;
    }

    public void setCharge_id(Long charge_id) {
        this.charge_id = charge_id;
    }

    public String getTd_id() {
        return td_id;
    }

    public void setTd_id(String td_id) {
        this.td_id = td_id;
    }

    public String getSeat_name() {
        return seat_name;
    }

    public void setSeat_name(String seat_name) {
        this.seat_name = seat_name;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }
}
