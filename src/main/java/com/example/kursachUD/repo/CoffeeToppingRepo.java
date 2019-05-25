package com.example.kursachUD.repo;

import com.example.kursachUD.model.CoffeeTopping;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeToppingRepo extends CrudRepository<CoffeeTopping, Integer> {
}