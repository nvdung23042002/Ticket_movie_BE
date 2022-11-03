package com.webmovieticket.repository;

import com.webmovieticket.models.AgentRecharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRechargeRepository extends JpaRepository<AgentRecharge, Long> {
}
