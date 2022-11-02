package com.webmovieticket.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movies extends BaseModel {
    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "cast")
    private String cast;

    @Column(name = "director")
    private String director;

    @Column(name = "music")
    private String music;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "lang")
    private String lang;

    @Column(name = "trailerUrl")
    private String trailerUrl;
}
