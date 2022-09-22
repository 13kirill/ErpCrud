package ru.netology.erpcrud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.erpcrud.entity.Customer;
import ru.netology.erpcrud.service.CustomerService;

import java.util.List;

@RestController
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customer/all")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("customer/by-id")
    public List<Customer> getCustomerById(@RequestParam("id") int id) {
        return customerService.getById(id);
    }

    @PostMapping("/customer/create")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.createCustomer(customer) + " created");
    }

    @PostMapping("/customer/update")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(customer) + " updated");
    }

    @DeleteMapping("/customer/delete")
    public ResponseEntity<String> deleteCustomer(@RequestParam("id") int id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.OK).body("Customer with " + id + " deleted");
    }
}
