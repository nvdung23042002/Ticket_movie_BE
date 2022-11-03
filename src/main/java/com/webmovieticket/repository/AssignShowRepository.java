package com.webmovieticket.repository;

import com.webmovieticket.models.AssignShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignShowRepository extends JpaRepository<AssignShow, Long> {
}
