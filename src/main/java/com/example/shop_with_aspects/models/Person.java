package com.example.shop_with_aspects.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Entity
@Table(name = "persons")
@Component
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double account;

}
