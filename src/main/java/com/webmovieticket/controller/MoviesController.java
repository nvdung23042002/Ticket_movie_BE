package com.webmovieticket.controller;

import com.webmovieticket.dto.MoviesDTO;
import com.webmovieticket.models.Movies;
import com.webmovieticket.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "test/movies")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping("")
    public List<MoviesDTO> getAllMovies() {
        return moviesService.findAll();
    }

    @GetMapping("/{id}")
    public MoviesDTO getMoviesById(@PathVariable Long id) {
        return moviesService.findById(id);
    }

//    Đưa ra Top Movies có rating cao nhất
    @GetMapping("/toprating")
    public List<MoviesDTO> getMoviesByRating() {
        return moviesService.findByRating();
    }

    @PostMapping("")
    public MoviesDTO insertMovies(@RequestBody Movies movies) {
        return moviesService.insert(movies);
    }

    @PutMapping("/{id}")
    public MoviesDTO updateMovies(@PathVariable Long id, @RequestBody Movies movies) {
        return moviesService.update(id, movies);
    }

    @DeleteMapping("")
    public void delete(@RequestBody Long[] ids) {
        moviesService.delete(ids);
    }
}
