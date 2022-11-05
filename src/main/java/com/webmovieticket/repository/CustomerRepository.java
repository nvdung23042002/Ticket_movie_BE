package com.webmovieticket.repository;

import com.webmovieticket.models.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerDetails, Long> {
}
