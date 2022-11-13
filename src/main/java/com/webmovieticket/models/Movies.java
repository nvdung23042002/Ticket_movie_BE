package com.webmovieticket.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movies extends BaseModel {
    private String name;
    private String image;
    private Double rating;
    private String cast;
    private String director;
    private String music;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    private String lang;
    private String trailerUrl;
}
