package com.webmovieticket.repository;

import com.webmovieticket.models.Charges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargesRepository extends JpaRepository<Charges, Long> {
}
