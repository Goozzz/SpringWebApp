package com.example.kursachUD.repo;


import com.example.kursachUD.model.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepo extends CrudRepository<Coffee, Integer> {
}
