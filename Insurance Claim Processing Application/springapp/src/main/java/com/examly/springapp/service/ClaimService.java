package com.examly.springapp.service;

import com.examly.springapp.exception.ResourceNotFoundException;

import com.examly.springapp.exception.ValidationException;

import com.examly.springapp.model.Claim;

import com.examly.springapp.repository.ClaimRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import java.time.LocalDate;

import java.util.Arrays;

import java.util.List;



@Service

public class ClaimService {

    @Autowired

    private ClaimRepository claimRepository;



    public Claim createClaim(Claim claim) {

        if (claim.getSubmissionDate() == null) {

            claim.setSubmissionDate(LocalDate.now());

        }

        if (claim.getStatus() == null) {

            claim.setStatus("SUBMITTED");

        }

        return claimRepository.save(claim);

    }

    public List<Claim> getAllClaims() {

        return claimRepository.findAll();

    }



    public Claim getClaimById(Long id) {

        return claimRepository.findById(id)

        .orElseThrow(() -> new ResourceNotFoundException("Claim not found with id: " + id));

    }



    public List<Claim> getClaimsByCustomerId(Long customerId) {

        return claimRepository.findByCustomerId(customerId);

    }



    public Claim updateClaimStatus(Long id, String status) {

        Claim claim = claimRepository.findById(id)

        .orElseThrow(() -> new ResourceNotFoundException("Claim not found with id: " + id));

        if (!isValidStatus(status)) {

            throw new ValidationException("Invalid claim status: " + status);

        }

            claim.setStatus(status);

            return claimRepository.save(claim);

    }



    private boolean isValidStatus(String status) {

        return Arrays.asList("SUBMITTED", "APPROVED", "REJECTED", "PENDING").contains(status);

    }

}