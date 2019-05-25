package com.example.kursachUD.controller;

import com.example.kursachUD.model.CoffeeTopping;


import com.example.kursachUD.repo.CoffeeToppingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CoffeeToppingController {
    @Autowired
    CoffeeToppingRepo coffeeToppingRepo;

    @GetMapping("/topping")
    public String coffeeTopping(Map<String, Object> model) {
        Iterable<CoffeeTopping> coffeeToppings = coffeeToppingRepo.findAll();
        model.put("coffeeToppings", coffeeToppings);
        return "topping";
    }

    @PostMapping("addCoffeeTopping")
    public String addCoffeeTopping(@RequestParam String coffeeToppingDescription, Map<String, Object> model) {
        CoffeeTopping coffeeTopping = new CoffeeTopping(coffeeToppingDescription);
        coffeeToppingRepo.save(coffeeTopping);
        Iterable<CoffeeTopping> coffeeToppings = coffeeToppingRepo.findAll();
        model.put("coffeeToppings", coffeeToppings);
        return "topping";
    }

    @PostMapping("deleteCoffeeTopping")
    public String deleteCoffeeTopping(@RequestParam Integer coffeeToppingId, Map<String, Object> model) {
        CoffeeTopping coffeeTopping = new CoffeeTopping(coffeeToppingId);
        coffeeToppingRepo.delete(coffeeTopping);
        Iterable<CoffeeTopping> coffeeToppings = coffeeToppingRepo.findAll();
        model.put("coffeeToppings", coffeeToppings);
        return "topping";
    }
}