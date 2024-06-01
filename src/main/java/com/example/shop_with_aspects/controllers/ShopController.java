package com.example.shop_with_aspects.controllers;

import com.example.shop_with_aspects.exeptions.NotEnoughMoneyException;
import com.example.shop_with_aspects.exeptions.NotEnoughQuantityException;
import com.example.shop_with_aspects.exeptions.ReserveStoreIsEmptyException;
import com.example.shop_with_aspects.models.Product;
import com.example.shop_with_aspects.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {

    @Autowired
    private ShopService service;

    @GetMapping
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }
    @PostMapping("/add")
    public void addProduct(@RequestBody Product product){
        service.addProduct(product);
    }


    @PutMapping("/reserve/{id}")
    public List<Product> productReserve(@PathVariable Long id, @RequestParam int quantity) throws NotEnoughQuantityException {
        service.addToReserveStore(id, quantity);
        return service.getAllProducts();
    }

    @GetMapping("/buy/{id}")
    public List<Product> buyProduct(@PathVariable Long id) throws NotEnoughMoneyException, ReserveStoreIsEmptyException {
        service.buyProduct(id);
        return service.getAllProducts();
    }
}
