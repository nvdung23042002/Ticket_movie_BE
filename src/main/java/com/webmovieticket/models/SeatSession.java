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
public class SeatSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String time;

    private Date date;

    private Long timestamp;

    private String ip;

}
