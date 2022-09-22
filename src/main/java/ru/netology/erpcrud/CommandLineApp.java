package ru.netology.erpcrud;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.erpcrud.entity.Customer;
import ru.netology.erpcrud.entity.Orders;
import ru.netology.erpcrud.entity.Product;
import ru.netology.erpcrud.repository.CustomerRepositoryJpa;


import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

//@RequiredArgsConstructor
@Component
public class CommandLineApp implements CommandLineRunner {

    //private final CustomerRepositoryJpa customerRepositoryJpa;
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) {

        var names = List.of("Вася", "Петя", "Саша", "Федя");

        var random = new Random();
        IntStream.range(0, 10)
                .forEach(i -> {
                    Customer customer = Customer.builder()
                            .name(names.get(random.nextInt(names.size())))
                            .site("somesite" + i + "@mail.ru")
                            .build();

                    entityManager.persist(customer);

                    //можно заполнять с помощью репозитория
                    //customerRepositoryJpa.save(customer);
                });

        IntStream.range(0, 10)
                .forEach(i -> {
                    Orders order = Orders.builder()
                            .date(random.nextInt(0, 100))
                            .codeword("someword" + i)
                            .build();

                    entityManager.persist(order);
                });

        IntStream.range(0, 10)
                .forEach(i -> {
                    Product product = Product.builder()
                            .productName("someproduct" + i)
                            .weight(123 * i)
                            .build();

                    entityManager.persist(product);
                });
    }
}
