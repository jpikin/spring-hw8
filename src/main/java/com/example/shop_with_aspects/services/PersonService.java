package com.example.shop_with_aspects.services;

import com.example.shop_with_aspects.models.Person;
import com.example.shop_with_aspects.repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;

    public List<Person> getAllPersons(){
        return personRepo.findAll();
    }
    public void addPerson(Person person){
        personRepo.save(person);
    }

    public Person findPersonById(Long id) {
        Optional<Person> optionalPerson = personRepo.findById(id);
        return optionalPerson.orElse(null);
    }
}
