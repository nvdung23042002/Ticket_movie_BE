package com.webmovieticket.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tickets")
public class Tickets extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movieId")
    @JsonIgnore
    private Movies movies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinemaId")
    @JsonIgnore
    private Cinemas cinemas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomId")
    @JsonIgnore
    private CinemaRoom cinemaRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seatId")
    @JsonIgnore
    private Seats seats;

    private String showDate;
    private String showMonth;
    private String showTime;
    private Integer price;
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;

    private Boolean paymentStatus = false;
    private Date paymentDate;
}