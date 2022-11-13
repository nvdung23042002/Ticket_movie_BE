package com.webmovieticket.repository;

import com.webmovieticket.models.CinemaRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, Long> {
    public CinemaRoom findByRoomName(String name);
}
