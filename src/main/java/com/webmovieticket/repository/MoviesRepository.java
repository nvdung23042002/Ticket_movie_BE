package com.webmovieticket.repository;

import com.webmovieticket.models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoviesRepository extends JpaRepository<Movies, Long> {
    List<Movies> findByName(String name);
}
