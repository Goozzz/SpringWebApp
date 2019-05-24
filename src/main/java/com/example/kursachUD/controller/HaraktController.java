package com.example.kursachUD.controller;

import com.example.kursachUD.model.Harakteristiki;


import com.example.kursachUD.model.Usr;
import com.example.kursachUD.repo.HaraktRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HaraktController {
    @Autowired
    HaraktRepo haraktRepo;

    @GetMapping("/harakt")
    public String harakt(Map<String, Object> model) {
        Iterable<Harakteristiki> harakts = haraktRepo.findAll(); //Поиск всех пользователей в бд
        model.put("harakts", harakts);               //Вывод всех пользователей на страничку в списке
        return "harakt";
    }

    @PostMapping("addHarakt")
    public String addHarakt(@RequestParam String harktDescription, Map<String, Object> model) {
        Harakteristiki harakt = new Harakteristiki(harktDescription);
        haraktRepo.save(harakt);
        Iterable<Harakteristiki> harakts = haraktRepo.findAll(); //Кусок необходим для обновления список с добавленными данными
        model.put("harakts", harakts);
        return "harakt";
    }

    @PostMapping("deleteHarakt")
    public String deleteHarakt(@RequestParam Integer harktId, Map<String, Object> model) {
        Harakteristiki harakt = new Harakteristiki(harktId);
        haraktRepo.delete(harakt);
        Iterable<Harakteristiki> harakts = haraktRepo.findAll(); //Кусок необходим для обновления список с добавленными данными
        model.put("harakts", harakts);
        return "harakt";
    }
}