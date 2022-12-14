package com.webmovieticket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviesDTO extends BaseDTO {
    private String name;
    private String image;
    private Double rating;
    private String cast;
    private String director;
    private String music;
    private String description;
    private String trailerUrl;
    private String lang;

    private String category;
    private String debut;
    private String language;
    private String movieDuration;
    private String rated;

    private Integer sumPriceAudit = 0;
    private Integer sumTicketAudit = 0;
}
