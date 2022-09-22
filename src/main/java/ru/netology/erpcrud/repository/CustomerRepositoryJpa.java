package ru.netology.erpcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.erpcrud.entity.Customer;
import ru.netology.erpcrud.entity.Orders;

import java.util.List;

public interface CustomerRepositoryJpa extends JpaRepository<Customer, Integer> {

    //Можно реализовать такой же репозиторий для orders и для products

    //Могу написать кастомные запросы.
    //Простые примеры:

//    List<Customer> findCustomerByCustomerCommentOrderByName(String comment);
//
//    List<Customer> findCustomerByIdIsLessThan(int id);

}
