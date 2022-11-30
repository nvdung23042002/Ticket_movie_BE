package com.webmovieticket.repository;

import com.webmovieticket.models.Seats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatsRepository extends JpaRepository<Seats, Long> {
}
