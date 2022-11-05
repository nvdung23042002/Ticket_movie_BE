package com.webmovieticket.repository;

import com.webmovieticket.models.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRepository extends JpaRepository<Tickets, Long> {
}
