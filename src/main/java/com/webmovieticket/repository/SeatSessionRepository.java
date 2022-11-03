package com.webmovieticket.repository;

import com.webmovieticket.models.SeatSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatSessionRepository extends JpaRepository<SeatSession, Long> {
}
