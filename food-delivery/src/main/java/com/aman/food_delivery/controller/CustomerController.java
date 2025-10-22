package com.aman.food_delivery.controller;

import com.aman.food_delivery.entity.Customers;
import com.aman.food_delivery.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customers>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    private ResponseEntity<Customers> getCustomerById(@PathVariable("customerId") Long customerId) {
        try {
            return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> removeUserById(@PathVariable("customerId") Long customerId) {
        try {
            customerService.removeUserById(customerId);
            return new ResponseEntity<>("User with Id " + customerId + " deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
        }
    }
}
