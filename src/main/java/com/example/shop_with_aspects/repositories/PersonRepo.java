package com.example.shop_with_aspects.repositories;

import com.example.shop_with_aspects.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long> {
}
