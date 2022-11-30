package com.webmovieticket.repository;

import com.webmovieticket.models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MoviesRepository extends JpaRepository<Movies, Long> {
    public Movies findByName(String name);

    @Query(value = "SELECT * FROM movies ORDER BY rating DESC LIMIT :size", nativeQuery = true)
    List<Movies> findMoviesByRating(@Param("size") int size);
}
