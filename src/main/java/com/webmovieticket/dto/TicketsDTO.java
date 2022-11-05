package com.webmovieticket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketsDTO extends BaseDTO {
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
