package com.webmovieticket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketsRequest {
    private Long id;
    private Long cinemasId;
    private Long roomId;
    private Long movieId;
    private String showDate;
    private String showMonth;
    private String showTime;
    private String category;
    private Integer price;
}
