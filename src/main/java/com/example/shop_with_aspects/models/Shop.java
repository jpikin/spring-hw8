package com.example.shop_with_aspects.models;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Shop {

    private double account;
}
