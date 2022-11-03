package com.webmovieticket.repository;

import com.webmovieticket.models.Theatres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatresRepository extends JpaRepository<Theatres, Long> {
}
