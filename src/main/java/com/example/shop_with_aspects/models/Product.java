package com.example.shop_with_aspects.models;

import com.example.shop_with_aspects.exeptions.NotEnougthQuantityException;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int mainStore;
    private int reserveStore;

    public void addToMainStore(int quantity) {
        mainStore += quantity;
    }
    public void delFromMainStore(int quantity) throws Exception {
        if (quantity <= mainStore){
            mainStore -= quantity;
        } else {
            throw new NotEnougthQuantityException();
        }
    }

    public void addToReserveStore(int quantity) {
        mainStore += quantity;
    }
    public void delFromReserveStore(int quantity) throws Exception {
        if (quantity <= reserveStore){
            reserveStore -= quantity;
        } else {
            throw new NotEnougthQuantityException();
        }
    }
}
