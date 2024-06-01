package com.example.shop_with_aspects.models;

import com.example.shop_with_aspects.exeptions.NotEnoughQuantityException;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int mainStore;
    @Column(nullable = false)
    private int reserveStore;

    public void addToMainStore(int quantity) {
        mainStore += quantity;
    }

    public void delFromMainStore(int quantity) throws NotEnoughQuantityException {
        if (quantity <= mainStore) {
            mainStore -= quantity;
            } else {
            throw new NotEnoughQuantityException();
        }
    }

    public void addToReserveStore(int quantity) {reserveStore += quantity;
    }

    public void delFromReserveStore(int quantity) throws Exception {
        if (quantity <= reserveStore) {
            reserveStore -= quantity;
            System.out.println(reserveStore);
        } else {
            throw new NotEnoughQuantityException();
        }
    }
}
