package com.examly.springapp.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Claim;
import com.examly.springapp.service.ClaimService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "https://8081-daadeedcbecfdaacedbdfdaffabfbdede.premiumproject.examly.io/")
public class ClaimController {

    @Autowired
    private ClaimService claimService;
    @PostMapping("/api/claims")
    public ResponseEntity<Claim> createClaim(@Valid @RequestBody Claim claim){
        if(claim.getSubmissionDate()==null){
            claim.setSubmissionDate(LocalDate.now());
        }
        if(claim.getStatus()==null||claim.getStatus().isEmpty()){
            claim.setStatus("SUBMITTED");
        }

        Claim createdClaim=claimService.createClaim(claim);
        URI location=URI.create("/api/claims/"+createdClaim.getId());
        return ResponseEntity.created(location).body(createdClaim);
    }
    @GetMapping("/api/claims")
    public List<Claim> getAllClaims(){
        return claimService.getAllClaims();
    }
    @GetMapping("/api/claims/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable Long id){
        Claim claim=claimService.getClaimById(id);
        return ResponseEntity.ok(claim);
    }
    @GetMapping("/api/customers/{customerId}/claims")
    public List<Claim> getClaimsForCustomer(@PathVariable Long customerId){
        return claimService.getClaimsByCustomerId(customerId);
    }
    // @GetMapping("/api/claims/customer/{customerId}")
    // public List<Claim> getClaimsByCustomerId(@PathVariable Long customerId){
    //     return claimService.getClaimsByCustomerId(customerId);
    // }
    @PutMapping("/api/claims/{id}/status")
    public ResponseEntity<Claim> updateClaimStatus(@PathVariable Long id,@RequestBody Map<String,String> statusRequest){
        String status=statusRequest.get("status");
        Claim updatedClaim=claimService.updateClaimStatus(id, status);
        return ResponseEntity.ok(updatedClaim);
    }
}
