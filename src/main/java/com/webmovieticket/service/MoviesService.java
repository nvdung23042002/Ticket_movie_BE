package com.webmovieticket.service;

import com.webmovieticket.dto.MoviesDTO;
import com.webmovieticket.mapper.MoviesMapper;
import com.webmovieticket.models.Movies;
import com.webmovieticket.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MoviesService  {

    @Autowired
    private MoviesMapper moviesMapper;

    @Autowired
    private MoviesRepository moviesRepository;

    public List<MoviesDTO> findAll() {
        return moviesRepository.findAll().stream().map(
                movies -> moviesMapper.toDto(movies)).collect(Collectors.toList()
        );
    }

    public MoviesDTO findById(Long id) {
        return moviesMapper.toDto(moviesRepository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    public List<MoviesDTO> findByName(String name) {
        return null;
    }

    public List<MoviesDTO> findByRating() {
        return moviesRepository.findMoviesByRating().stream().map(
                movies -> moviesMapper.toDto(movies)).collect(Collectors.toList());
    }

    @Transactional
    public MoviesDTO insert(Movies movies) {
        return moviesMapper.toDto(moviesRepository.save(movies));
    }

    @Transactional
    public MoviesDTO update(Long id, Movies movies) {
        Movies oldMovies = moviesRepository.findById(id).orElseGet(() -> null);
        if (oldMovies != null) {
            return moviesMapper.update(oldMovies, movies);
        } else {
            return null;
        }
    }

    @Transactional
    public void delete(Long[] ids) {
        for (Long id : ids) {
            moviesRepository.deleteById(id);
        }
    }
}
