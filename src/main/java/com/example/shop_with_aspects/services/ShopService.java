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
public class ShopService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private Person person;
    @Autowired
    private Shop shop;
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

    public void buyProduct(Long id) throws NotEnoughMoneyException, ReserveStoreIsEmptyException {
        if (cost != 0) {
            buyProductTransaction();
            Optional<Product> optionalProduct = productRepo.findById(id);
            if(optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                product.setReserveStore(0);
                productRepo.save(product);
            }
        }
        else throw new ReserveStoreIsEmptyException();
    }

    @Transactional
    private void buyProductTransaction() throws NotEnoughMoneyException {
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
