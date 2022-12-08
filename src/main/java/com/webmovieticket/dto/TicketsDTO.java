package com.webmovieticket.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webmovieticket.models.CinemaRoom;
import com.webmovieticket.models.Cinemas;
import com.webmovieticket.models.Movies;
import com.webmovieticket.models.Seats;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketsDTO extends BaseDTO {

    private String category;
    private Long customerId;
    private Boolean paymentStatus = false;
    private Date paymentDate;

    private Integer price;
    private String showDate;
    private String showMonth;
    private String showTime;
    private String movieName;
    private String cinemaName;
    private String roomName;
    private String seatName;
    private Long userId;
}
