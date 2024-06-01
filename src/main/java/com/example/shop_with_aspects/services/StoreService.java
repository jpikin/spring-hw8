package com.example.shop_with_aspects.services;

import com.example.shop_with_aspects.exeptions.NotEnoughMoneyException;
import com.example.shop_with_aspects.exeptions.NotEnoughQuantityException;
import com.example.shop_with_aspects.exeptions.ReserveStoreIsEmptyException;
import com.example.shop_with_aspects.models.Person;
import com.example.shop_with_aspects.models.Product;
import com.example.shop_with_aspects.models.Shop;
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
    @Autowired
    private Person person;
    @Autowired
    private Shop shop;
    @Autowired
    private double cost;

    @Transactional
    public void addToMainStore(Long id ,int quantity) throws Exception {
        Product product = productRepo.getReferenceById(id);
        product.delFromReserveStore(quantity);
        product.addToMainStore(quantity);
    }
    @Transactional
    public void addToReserveStore(Long id ,int quantity) throws NotEnoughQuantityException {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.delFromMainStore(quantity);
            product.addToReserveStore(quantity);
            productRepo.save(product);
            cost = product.getPrice()*product.getReserveStore();
        }
    }

    public void buyProduct() throws NotEnoughMoneyException, ReserveStoreIsEmptyException {
        if (cost != 0) buyProductTransaction();
        else throw new ReserveStoreIsEmptyException();
    }

    @Transactional
    public void buyProductTransaction() throws NotEnoughMoneyException {
        delMoneyFromPersonAccount(cost);
        addMoneyToShopAccount(cost);
    }

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }
    public void addProduct(Product product){
        productRepo.save(product);
    }
    public void delMoneyFromPersonAccount(double cost) throws NotEnoughMoneyException {
        if (cost <= person.getAccount()) {
            person.setAccount(person.getAccount() - cost);
            } else {
            throw new NotEnoughMoneyException();
        }
    }
    public void addMoneyToShopAccount(double cost){
        shop.setAccount(shop.getAccount() + cost);
    }
}
