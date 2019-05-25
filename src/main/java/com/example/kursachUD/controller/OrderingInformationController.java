package com.example.kursachUD.controller;


import com.example.kursachUD.model.CoffeeShopWorker;
import com.example.kursachUD.model.Coffee;
import com.example.kursachUD.model.OrderingInformation;
import com.example.kursachUD.model.Usr;
import com.example.kursachUD.repo.CoffeeShopWorkerRepo;
import com.example.kursachUD.repo.CoffeeRepo;
import com.example.kursachUD.repo.UsrRepo;
import com.example.kursachUD.repo.OrderingInformationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class OrderingInformationController {
    @Autowired
    private OrderingInformationRepo orderingInformationRepo;
    @Autowired
    private UsrRepo userRepo;
    @Autowired
    private CoffeeShopWorkerRepo coffeeShopWorkerRepo;
    @Autowired
    private CoffeeRepo coffeeRepo;

    @GetMapping("/orderingInformation")
    public String orderingInformation(Map<String, Object> model) {
        Iterable<OrderingInformation> orderingInformations = orderingInformationRepo.findAll(); //Поиск всех пользователей в бд
        model.put("orderingInformations", orderingInformations);               //Вывод всех пользователей на страничку в списке
        return "orderingInformation";
    }

    @PostMapping("addOrderingInformation")
    public String addOrderingInformation(@RequestParam Integer userId,
                                         @RequestParam String orderingInformationName,
                                         @RequestParam Integer coffeeShopWorkerId,
                                         @RequestParam Integer coffeeId,
                                         Map<String, Object> model) {

        OrderingInformation orderingInformation = new OrderingInformation(orderingInformationName);
        try {
            Usr user = userRepo.findById(userId).get();
            CoffeeShopWorker coffeeShopWorker = coffeeShopWorkerRepo.findById(coffeeShopWorkerId).get();
            Coffee coffee = coffeeRepo.findById(coffeeId).get();
            coffeeShopWorker.getOrderingInformations().add(orderingInformation);
            user.getOrderingInformations().add(orderingInformation);
            coffee.getOrderingInformations().add(orderingInformation);


            orderingInformationRepo.save(orderingInformation);
            coffeeRepo.save(coffee);
            userRepo.save(user);
            coffeeShopWorkerRepo.save(coffeeShopWorker);

        } catch (Exception e) {

        }

        Iterable<OrderingInformation> orderingInformations = orderingInformationRepo.findAll(); //Поиск всех пользователей в
        model.put("orderingInformations", orderingInformations);               //Вывод всех пользователей на страничку в списке

        return "orderingInformation";
    }

    @PostMapping("deleteOrderingInformation")
    public String deleteOrderingInformation(@RequestParam Integer orderingInformationId, Map<String, Object> model) {
        OrderingInformation order = new OrderingInformation(orderingInformationId);
        orderingInformationRepo.delete(order);
        Iterable<OrderingInformation> orderingInformations = orderingInformationRepo.findAll(); //Поиск всех пользователей в бд
        model.put("orderingInformations", orderingInformations);               //Вывод всех пользователей на страничку в списке
        return "orderingInformation";
    }
}

