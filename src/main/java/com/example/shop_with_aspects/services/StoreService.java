package com.example.shop_with_aspects.services;

import com.example.shop_with_aspects.models.Product;
import com.example.shop_with_aspects.repositories.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    private ProductRepo productRepo;

    @Transactional
    public void addToMainStore(Long id ,int quantity) throws Exception {
        Product product = productRepo.getProductById(id);
        product.delFromReserveStore(quantity);
        product.addToMainStore(quantity);
    }
    @Transactional
    public void addToReserveStore(Long id ,int quantity) throws Exception {
        Product product = productRepo.getProductById(id);
        product.delFromMainStore(quantity);
        product.addToReserveStore(quantity);
    }
}
