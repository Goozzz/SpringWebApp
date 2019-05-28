package com.example.kursachUD.controller;

import com.example.kursachUD.model.CoffeeShopWorker;
import com.example.kursachUD.repo.CoffeeShopWorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CoffeeShopWorkerController {
    @Autowired
    private CoffeeShopWorkerRepo coffeeShopWorkerRepo;

    @GetMapping("/worker")
    public String shopWorker(Map<String, Object> model) {
        Iterable<CoffeeShopWorker> coffeeShopWorkers = coffeeShopWorkerRepo.findAll();
        model.put("coffeeShopWorkers", coffeeShopWorkers);
        return "worker";
    }

    @PostMapping("addCoffeeShopWorker")
    public String addCoffeeShopWorker(@RequestParam String coffeeShopWorkerName,
                          @RequestParam String coffeeShopWorkerEmail,
                          @RequestParam String coffeeShopWorkerPhoneNumber,
                          Map<String, Object> model) {

        CoffeeShopWorker coffeeShopWorker = new CoffeeShopWorker(coffeeShopWorkerName, coffeeShopWorkerPhoneNumber, coffeeShopWorkerEmail);
        coffeeShopWorkerRepo.save(coffeeShopWorker);
        Iterable<CoffeeShopWorker> coffeeShopWorkers = coffeeShopWorkerRepo.findAll();
        model.put("coffeeShopWorkers", coffeeShopWorkers);
        return "worker";
    }

    @PostMapping("deleteCoffeeShopWorker")
    public String deleteCoffeeShopWorker(@RequestParam Integer coffeeShopWorkerId, Map<String, Object> model) {
        CoffeeShopWorker coffeeShopWorker = new CoffeeShopWorker(coffeeShopWorkerId);
        coffeeShopWorkerRepo.delete(coffeeShopWorker);
        Iterable<CoffeeShopWorker> coffeeShopWorkers = coffeeShopWorkerRepo.findAll();
        model.put("coffeeShopWorkers", coffeeShopWorkers);
        return "worker";
    }

    @PostMapping("updateCoffeeShopWorker")
    public String updateCoffeeShopWorker(@RequestParam Integer coffeeShopWorkerId,
                             @RequestParam String coffeeShopWorkerName,
                             @RequestParam String coffeeShopWorkerEmail,
                             @RequestParam String coffeeShopWorkerPhoneNumber,
                             Map<String, Object> model) {

        try {
            CoffeeShopWorker coffeeShopWorker;
            coffeeShopWorker = coffeeShopWorkerRepo.findById(coffeeShopWorkerId).get();
            if (!coffeeShopWorkerName.equals("")) {
                coffeeShopWorker.setCoffeeShopWorkerName(coffeeShopWorkerName);
            }
            if (!coffeeShopWorkerEmail.equals("")) {
                coffeeShopWorker.setCoffeeShopWorkerEmail(coffeeShopWorkerEmail);
            }
            if (!coffeeShopWorkerPhoneNumber.equals("")) {
                coffeeShopWorker.setCoffeeShopWorkerPhoneNumber(coffeeShopWorkerPhoneNumber);
            }
            coffeeShopWorkerRepo.save(coffeeShopWorker);
        } catch (Exception e) {

        }
        Iterable<CoffeeShopWorker> coffeeShopWorkers = coffeeShopWorkerRepo.findAll();
        model.put("coffeeShopWorkers", coffeeShopWorkers);
        return "worker";
    }
}
