package com.example.shop_with_aspects.services;

import com.example.shop_with_aspects.models.Product;
import com.example.shop_with_aspects.repositories.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private ProductRepo productRepo;

    @Transactional
    public void addToMainStore(Long id ,int quantity) throws Exception {
        Product product = productRepo.getReferenceById(id);
        product.delFromReserveStore(quantity);
        product.addToMainStore(quantity);
    }
    @Transactional
    public void addToReserveStore(Long id ,int quantity) throws Exception {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.delFromMainStore(quantity);
            product.addToReserveStore(quantity);
            productRepo.save(product);
        }
    }

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }
    public void addProduct(Product product){
        productRepo.save(product);
    }
}
