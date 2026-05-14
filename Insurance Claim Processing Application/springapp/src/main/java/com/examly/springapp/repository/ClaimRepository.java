package com.examly.springapp.repository;

import com.examly.springapp.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
    // List<Claim> findByStatus(String status);
    List<Claim> findByCustomerId(Long customerId);
}
