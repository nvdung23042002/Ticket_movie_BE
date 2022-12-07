package com.webmovieticket.repository;

import com.webmovieticket.models.TransactionHis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionHisRepository extends JpaRepository<TransactionHis, Long> {
}
