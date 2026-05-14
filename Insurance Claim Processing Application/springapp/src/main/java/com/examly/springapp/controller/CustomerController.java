package com.examly.springapp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Customer;
import com.examly.springapp.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "https://8081-daadeedcbecfdaacedbdfdaffabfbdede.premiumproject.examly.io/")

public class CustomerController {
    @Autowired
    CustomerService customerservice;
    @PostMapping("/api/customers")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer){
        Customer createdCustomer=customerservice.createCustomer(customer);
        URI location=URI.create("/api/customers/"+createdCustomer.getCustomerId());
        return ResponseEntity.created(location).body(createdCustomer);
    }
    
    @GetMapping("/api/customers")
    public List<Customer> getAllCustomers(){
        return customerservice.getAllCustomers();
    }
    
    @GetMapping("/api/customers/{customerId}")
    public ResponseEntity<Customer>getCustomerById(@PathVariable Long customerId){
        Customer customer=customerservice.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }
}
