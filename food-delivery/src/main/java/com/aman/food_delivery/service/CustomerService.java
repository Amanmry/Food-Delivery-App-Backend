package com.aman.food_delivery.service;

import com.aman.food_delivery.entity.Customers;
import com.aman.food_delivery.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customers> getAllCustomers() {
        return customerRepository.findAll();
    }
}
