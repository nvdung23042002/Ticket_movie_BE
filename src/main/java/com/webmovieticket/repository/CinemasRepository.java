package com.webmovieticket.repository;

import com.webmovieticket.models.Cinemas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemasRepository extends JpaRepository<Cinemas, Long> {
    public Cinemas findByCinemaName(String name);
}
