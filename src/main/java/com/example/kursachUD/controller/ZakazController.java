package com.example.kursachUD.controller;


import com.example.kursachUD.model.Sotrudnik;
import com.example.kursachUD.model.Coffee;
import com.example.kursachUD.model.Usr;
import com.example.kursachUD.model.Zakaz;
import com.example.kursachUD.repo.SotrudnikRepo;
import com.example.kursachUD.repo.CoffeeRepo;
import com.example.kursachUD.repo.UsrRepo;
import com.example.kursachUD.repo.ZakazRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ZakazController {
    @Autowired
    private ZakazRepo zakazRepo;
    @Autowired
    private UsrRepo userRepo;
    @Autowired
    private SotrudnikRepo sotrudnikRepo;
    @Autowired
    private CoffeeRepo coffeeRepo;

    @GetMapping("/zakaz")
    public String zakaz(Map<String,Object> model) {
        Iterable<Zakaz> zakazs =  zakazRepo.findAll(); //Поиск всех пользователей в бд
        model.put("zakazs", zakazs);               //Вывод всех пользователей на страничку в списке
        return "zakaz";
    }

    @PostMapping("addZakaz")
    public String addZakaz(@RequestParam Integer userId,@RequestParam String zakazName, @RequestParam Integer sotrId,  @RequestParam Integer tovarId, Map<String,Object> model){
        Zakaz zakaz = new Zakaz(zakazName);
        try {
            Usr user = userRepo.findById(userId).get();
            Sotrudnik sotrudnik = sotrudnikRepo.findById(sotrId).get();
            Coffee coffee = coffeeRepo.findById(tovarId).get();
            sotrudnik.getZakazs().add(zakaz);
            user.getZakazs().add(zakaz);
            coffee.getZakazs().add(zakaz);

            
            zakazRepo.save(zakaz);
            coffeeRepo.save(coffee);
            userRepo.save(user);
            sotrudnikRepo.save(sotrudnik);

        }catch (Exception e) {

        }

        Iterable<Zakaz> zakazs =  zakazRepo.findAll(); //Поиск всех пользователей в
        model.put("zakazs", zakazs);               //Вывод всех пользователей на страничку в списке


        return "zakaz";
    }

    @PostMapping("deleteOrder")
    public String deleteZakaz(@RequestParam Integer orderId,Map<String,Object> model){
        Zakaz order = new Zakaz(orderId);
        zakazRepo.delete(order);
        Iterable<Zakaz> zakazs =  zakazRepo.findAll(); //Поиск всех пользователей в бд
        model.put("zakazs", zakazs);               //Вывод всех пользователей на страничку в списке
        return "zakaz";
    }

//    @PostMapping("updateOrder")
//    public String updateSotr(@RequestParam Integer orderId,@RequestParam Integer sotrId, @RequestParam Integer userId,Map<String,Object> model){
//        Order order = null;
//        try {
//            order = orderRepo.findById(orderId).get();
//        }catch(Exception e)
//        {
//
//        }
//        Iterable<Order> orders =  orderRepo.findAll(); //Поиск всех пользователей в бд
//        model.put("orders", orders);               //Вывод всех пользователей на страничку в списке
//        return "sotr";
//    }
}
