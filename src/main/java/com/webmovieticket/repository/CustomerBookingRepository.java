package com.webmovieticket.repository;

import com.webmovieticket.models.CustomerBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerBookingRepository extends JpaRepository<CustomerBooking, Long> {
}
