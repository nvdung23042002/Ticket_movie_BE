package com.webmovieticket.dto;

import java.util.Date;

public class CustomerBookingDTO {
    private Long id;

    private Long fk_show_id;

    private String seat_id;

    private String seat_name;

    private String changes;

    private String show_date;

    private String show_time;

    private Date booking_dt;

    private Long fk_cust_id;

    private Long fk_movie_id;

    private String convenience;

    private String serviceTax;

    private String concession;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFk_show_id() {
        return fk_show_id;
    }

    public void setFk_show_id(Long fk_show_id) {
        this.fk_show_id = fk_show_id;
    }

    public String getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(String seat_id) {
        this.seat_id = seat_id;
    }

    public String getSeat_name() {
        return seat_name;
    }

    public void setSeat_name(String seat_name) {
        this.seat_name = seat_name;
    }

    public String getChanges() {
        return changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }

    public String getShow_date() {
        return show_date;
    }

    public void setShow_date(String show_date) {
        this.show_date = show_date;
    }

    public String getShow_time() {
        return show_time;
    }

    public void setShow_time(String show_time) {
        this.show_time = show_time;
    }

    public Date getBooking_dt() {
        return booking_dt;
    }

    public void setBooking_dt(Date booking_dt) {
        this.booking_dt = booking_dt;
    }

    public Long getFk_cust_id() {
        return fk_cust_id;
    }

    public void setFk_cust_id(Long fk_cust_id) {
        this.fk_cust_id = fk_cust_id;
    }

    public Long getFk_movie_id() {
        return fk_movie_id;
    }

    public void setFk_movie_id(Long fk_movie_id) {
        this.fk_movie_id = fk_movie_id;
    }

    public String getConvenience() {
        return convenience;
    }

    public void setConvenience(String convenience) {
        this.convenience = convenience;
    }

    public String getServiceTax() {
        return serviceTax;
    }

    public void setServiceTax(String serviceTax) {
        this.serviceTax = serviceTax;
    }

    public String getConcession() {
        return concession;
    }

    public void setConcession(String concession) {
        this.concession = concession;
    }
}
