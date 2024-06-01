package com.example.shop_with_aspects.controllers;

import com.example.shop_with_aspects.models.Person;
import com.example.shop_with_aspects.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/person")
    private List<Person> getAllPersons(){
        return service.getAllPersons();
    }

    @PostMapping("/addPerson")
    public void addPerson(@RequestBody Person person){
        service.addPerson(person);
    }
}
