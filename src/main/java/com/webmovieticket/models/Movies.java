package com.webmovieticket.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movies extends BaseModel {
    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "rating")
    private String rating;

    @Column(name = "cast")
    private String cast;

    @Column(name = "director")
    private String director;

    @Column(name = "music")
    private String music;

    @Column(name = "_desc")
    private String desc;

    @Column(name = "lang")
    private String lang;

    @Column(name = "releaseDate")
    private String releaseDate;

    public Movies() {
    }

    public Movies(String name, String image, String rating, String cast, String director, String music, String desc, String lang, String releaseDate) {
        this.name = name;
        this.image = image;
        this.rating = rating;
        this.cast = cast;
        this.director = director;
        this.music = music;
        this.desc = desc;
        this.lang = lang;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
