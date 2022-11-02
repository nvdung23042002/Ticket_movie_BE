package com.webmovieticket.mapper;

import com.webmovieticket.dto.MoviesDTO;
import com.webmovieticket.models.Movies;
import com.webmovieticket.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MoviesMapper {
    @Autowired
    private MoviesRepository moviesRepository;

    public MoviesDTO toDto(Movies movies) {
        MoviesDTO result = new MoviesDTO();
        result.setId(movies.getId());
        result.setName(movies.getName());
        result.setImage(movies.getImage());
        result.setRating(movies.getRating());
        result.setCast(movies.getCast());
        result.setDirector(movies.getDirector());
        result.setMusic(movies.getMusic());
        result.setDescription(movies.getDescription());
        result.setLang(movies.getLang());
        result.setTrailerUrl(movies.getTrailerUrl());

        return result;
    }

    public Movies toEntity(MoviesDTO moviesDTO) {
        Movies result = new Movies();

        result.setName(moviesDTO.getName());
        result.setImage(moviesDTO.getImage());
        result.setRating(moviesDTO.getRating());
        result.setCast(moviesDTO.getCast());
        result.setDirector(moviesDTO.getDirector());
        result.setMusic(moviesDTO.getMusic());
        result.setDescription(moviesDTO.getDescription());
        result.setLang(moviesDTO.getLang());
        result.setTrailerUrl(moviesDTO.getTrailerUrl());

        return result;
    }

    public MoviesDTO update(Movies oldMovies, Movies newMovies) {
        oldMovies.setName(newMovies.getName());
        oldMovies.setImage(newMovies.getImage());
        oldMovies.setRating(newMovies.getRating());
        oldMovies.setCast(newMovies.getCast());
        oldMovies.setDirector(newMovies.getDirector());
        oldMovies.setMusic(newMovies.getMusic());
        oldMovies.setDescription(newMovies.getDescription());
        oldMovies.setLang(newMovies.getLang());
        oldMovies.setTrailerUrl(newMovies.getTrailerUrl());

        return MoviesMapper.this.toDto(oldMovies);
    }
}
