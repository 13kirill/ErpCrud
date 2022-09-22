package ru.netology.erpcrud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int date;

    @Column
    private String codeword;

    @Column
    private String status;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "orders")
    private List<Product> productList;
}
