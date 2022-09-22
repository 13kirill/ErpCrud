package ru.netology.erpcrud.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.netology.erpcrud.entity.Customer;
import ru.netology.erpcrud.repository.CustomerRepositoryJpa;

import java.util.Collections;
import java.util.List;

@Service
public class CustomerService {

    CustomerRepositoryJpa customerRepositoryJpa;

    public CustomerService(CustomerRepositoryJpa customerRepositoryJpa) {
        this.customerRepositoryJpa = customerRepositoryJpa;
    }

    public List<Customer> findAll() {
        return customerRepositoryJpa.findAll();
    }

    public List<Customer> getById(int id) {
        return customerRepositoryJpa.findAllById(Collections.singleton(id));
    }

    public Customer createCustomer(Customer customer) {
        return customerRepositoryJpa.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
       // if (customerRepositoryJpa.existsById(customer.getId()))
            return customerRepositoryJpa.save(customer);
    }

    public void deleteCustomer(int id) {
        customerRepositoryJpa.deleteById(id);
    }

}
