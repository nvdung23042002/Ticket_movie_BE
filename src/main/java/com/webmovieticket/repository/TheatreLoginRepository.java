package com.webmovieticket.repository;

import com.webmovieticket.models.TheatreLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreLoginRepository extends JpaRepository<TheatreLogin, Long> {
}
