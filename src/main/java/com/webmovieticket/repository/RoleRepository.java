package com.webmovieticket.repository;

import com.webmovieticket.models.enums.ERole;
import com.webmovieticket.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
