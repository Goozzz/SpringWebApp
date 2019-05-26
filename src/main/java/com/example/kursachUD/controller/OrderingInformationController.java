package com.example.kursachUD.controller;


import com.example.kursachUD.model.*;
import com.example.kursachUD.repo.CoffeeShopWorkerRepo;
import com.example.kursachUD.repo.CoffeeRepo;
import com.example.kursachUD.repo.UsrRepo;
import com.example.kursachUD.repo.OrderingInformationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

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
        Iterable<OrderingInformation> orderingInformations = orderingInformationRepo.findAll();
        Collection<OrderingForView> orderingForViews = outputAllOrderInformation(orderingInformations,false, model);
        model.put("orderingForViews", orderingForViews);
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

            orderingInformation.setCoffeeShopWorker(coffeeShopWorker);
            orderingInformation.setUser(user);

            orderingInformationRepo.save(orderingInformation);
            coffeeRepo.save(coffee);
            userRepo.save(user);
            coffeeShopWorkerRepo.save(coffeeShopWorker);

        } catch (Exception e) {

        }

        Iterable<OrderingInformation> orderingInformations = orderingInformationRepo.findAll();

        Collection<OrderingForView> orderingForViews = outputAllOrderInformation(orderingInformations,false, model);

        model.put("orderingForViews", orderingForViews);

        return "orderingInformation";
    }

    @PostMapping("deleteOrderingInformation")
    public String deleteOrderingInformation(@RequestParam Integer orderingInformationId, Map<String, Object> model) {
        OrderingInformation order = new OrderingInformation(orderingInformationId);
        orderingInformationRepo.delete(order);
        Iterable<OrderingInformation> orderingInformations = orderingInformationRepo.findAll();
        outputAllOrderInformation(orderingInformations,false, model);
        model.put("orderingInformations", orderingInformations);
        return "orderingInformation";
    }

    @PostMapping("showDetailOrder")
    public String showDetailOrderingInformation(@RequestParam Integer orderingInformationId, Map<String, Object> model) {
        try {
            OrderingInformation orderingInformation = null;
            if(orderingInformationRepo.findById(orderingInformationId).isPresent()) {
                orderingInformation = orderingInformationRepo.findById(orderingInformationId).get();
            }

            if (orderingInformation == null) {
                Iterable<OrderingInformation> orderingInformations = orderingInformationRepo.findAll();
                outputAllOrderInformation(orderingInformations,false, model);
            } else {
                Collection<OrderingInformation> orderingInformations = new ArrayList<>();
                orderingInformations.add(orderingInformation);
                outputAllOrderInformation(orderingInformations,true, model);
            }
        } catch (Exception e) {
            Iterable<OrderingInformation> orderingInformations = orderingInformationRepo.findAll();
            outputAllOrderInformation(orderingInformations,false, model);
        }


        return "orderingInformation";
    }
    @PostMapping("addCoffeeToOrder")
    public String addCoffee(@RequestParam Integer orderingInformationId,
                             @RequestParam Integer coffeeId,
                             Map<String, Object> model ) {

        try {
            OrderingInformation orderingInformation = orderingInformationRepo.findById(orderingInformationId).get();
            Coffee coffee = coffeeRepo.findById(coffeeId).get();
            orderingInformation.getCoffees().add(coffee);
        } catch (Exception e) {

        }

        Iterable<OrderingInformation> orderingInformations = orderingInformationRepo.findAll();
        outputAllOrderInformation(orderingInformations,false, model);
        return "orderingInformation";
    }

    private Collection<OrderingForView> outputAllOrderInformation(Iterable<OrderingInformation> orderingInformations, boolean flag, Map<String, Object> model) {

        Collection<OrderingForView> orderingForViews = new ArrayList<>();
        for (OrderingInformation orderInform: orderingInformations) {
            String userName = orderInform.getUser().getUserName();
            String coffeeShopWorkerName = orderInform.getCoffeeShopWorker().getCoffeeShopWorkerName();
            Integer orderId = orderInform.getOrderingInformationId();
            String orderDescription = orderInform.getOrderingInformationName();
            Set<Coffee> coffeeList = null;
            if(flag){
                coffeeList = orderInform.getCoffees();
            }
            orderingForViews.add(new OrderingForView(orderId,orderDescription, userName, coffeeShopWorkerName, coffeeList));


        }
        model.put("orderingForViews", orderingForViews);

        return  orderingForViews;
    }


}

