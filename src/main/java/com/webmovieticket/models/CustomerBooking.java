package com.webmovieticket.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


}
