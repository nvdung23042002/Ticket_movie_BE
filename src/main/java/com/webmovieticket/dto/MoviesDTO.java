package com.webmovieticket.dto;

import lombok.Data;

@Data
public class MoviesDTO extends BaseDTO {
    private String name;

    private String image;

    private Double rating;

    private String cast;

    private String director;

    private String music;

    private String description;

    private String lang;
}
