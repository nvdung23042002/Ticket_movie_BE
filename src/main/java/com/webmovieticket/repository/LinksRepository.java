package com.webmovieticket.repository;

import com.webmovieticket.models.Links;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinksRepository extends JpaRepository<Links, Long> {
}
