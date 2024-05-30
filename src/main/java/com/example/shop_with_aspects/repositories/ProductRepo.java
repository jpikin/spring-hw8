package com.example.shop_with_aspects.repositories;

import com.example.shop_with_aspects.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    public List<Product> getAllProducts();
    public Product getProductById(Long id);
}
