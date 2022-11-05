package com.webmovieticket.models;

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
    private String seatName;
    private String showDate;
    private String showTime;
    private String category;
    private Long theaterId;
    private Long localId;
    private Double price;

    private Long customerId;
    private Boolean paymentStatus = false;
    private Date paymentDate;
}
