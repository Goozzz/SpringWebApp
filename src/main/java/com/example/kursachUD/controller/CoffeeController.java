package com.example.kursachUD.controller;

import com.example.kursachUD.model.Coffee;
import com.example.kursachUD.repo.CoffeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CoffeeController {
    @Autowired
    private CoffeeRepo coffeeRepo;

    @GetMapping("/coffee")
    public String coffee(Map<String,Object> model){
        Iterable<Coffee> coffees =  coffeeRepo.findAll(); //Поиск всех пользователей в бд
        model.put("coffees", coffees);               //Вывод всех пользователей на страничку в списке
        return "coffee";
    }

    @PostMapping("addCoffee")
    public String addCoffee(@RequestParam String coffeeName, @RequestParam Integer coffeePrice, Map<String,Object> model){
        if(!coffeeName.equals("") && !coffeePrice.equals(null)) {
            Coffee coffee = new Coffee(coffeeName,coffeePrice);
            coffeeRepo.save(coffee);
        }
        Iterable<Coffee> coffees =  coffeeRepo.findAll(); //Кусок необходим для обновления список с добавленными данными
        model.put("coffees", coffees);
        return "coffee";
    }



    @PostMapping("deleteCoffee")
    public String deleteCoffee(@RequestParam Integer coffeeId,Map<String,Object> model){
        Coffee coffee = new Coffee(coffeeId);
        coffeeRepo.delete(coffee);
        Iterable<Coffee> coffees =  coffeeRepo.findAll(); //Кусок необходим для обновления список с добавленными данными
        model.put("coffees", coffees);
        return "coffee";
    }

    @PostMapping("updateCoffee")
    public String updateCoffee(@RequestParam Integer coffeeId, @RequestParam String coffeeName, @RequestParam Integer coffeePrice, Map<String,Object> model) {
        try {
            Coffee coffee;
            coffee = coffeeRepo.findById(coffeeId).get();
            if(!coffeeName.equals("")) {
                coffee.setCoffeeName(coffeeName);
            }
            if(!coffeePrice.equals("")) {
                coffee.setCoffeePrice(coffeePrice);
            }

           coffeeRepo.save(coffee);
        } catch(Exception e) {

        }
        Iterable<Coffee> coffees = coffeeRepo.findAll(); //Кусок необходим для обновления список с добавленными данными
        model.put("coffees", coffees);
        return "coffee";
    }
}
