package com.example.kursachUD.controller;

import com.example.kursachUD.model.Zakaz;
import com.example.kursachUD.model.Sotrudnik;
import com.example.kursachUD.repo.ZakazRepo;
import com.example.kursachUD.repo.SotrudnikRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class SotrudnikController {
    @Autowired
    private SotrudnikRepo sotrudnikRepo;

    @Autowired
    private ZakazRepo zakazRepo;

    @GetMapping("/sotr")
    public String sotr(Map<String,Object> model) {
        Iterable<Sotrudnik> sotrudniks =  sotrudnikRepo.findAll(); //Поиск всех пользователей в бд
        model.put("sotrudniks", sotrudniks);               //Вывод всех пользователей на страничку в списке
        return "sotr";
    }

    @PostMapping("aaaa")
    public String aaaa(Map<String,Object> model){
        Sotrudnik sotrudnik = new Sotrudnik("Artem", "asd", "MoiHyi");
        Zakaz zakaz = new Zakaz("CHMO");
        sotrudnik.getZakazs().add(zakaz);
        zakazRepo.save(zakaz);
        sotrudnikRepo.save(sotrudnik);
        Iterable<Sotrudnik> sotrudniks =  sotrudnikRepo.findAll(); //Поиск всех пользователей в бд
        model.put("sotrudniks", sotrudniks);               //Вывод всех пользователей на страничку в списке
        return "sotr";
    }

    @PostMapping("addSotr")
    public String addSotr(@RequestParam String sotrName, @RequestParam String sotrEmail, @RequestParam String sotrPhoneNumber, Map<String,Object> model){
        Sotrudnik sotrudnik =  new Sotrudnik(sotrName, sotrPhoneNumber, sotrEmail);
        sotrudnikRepo.save(sotrudnik);
        Iterable<Sotrudnik> sotrudniks =  sotrudnikRepo.findAll(); //Поиск всех пользователей в бд
        model.put("sotrudniks", sotrudniks);               //Вывод всех пользователей на страничку в списке
        return "sotr";
    }

    @PostMapping("deleteSotr")
    public String deleteSotr(@RequestParam Integer sotrId,Map<String,Object> model){
        Sotrudnik sotrudnik = new Sotrudnik(sotrId);
        sotrudnikRepo.delete(sotrudnik);
        Iterable<Sotrudnik> sotrudniks =  sotrudnikRepo.findAll(); //Поиск всех пользователей в бд
        model.put("sotrudniks", sotrudniks);               //Вывод всех пользователей на страничку в списке
        return "sotr";
    }

    @PostMapping("updateSotr")
    public String updateSotr(@RequestParam Integer sotrId, @RequestParam String sotrName, @RequestParam String sotrEmail,@RequestParam String sotrPhoneNumber, Map<String,Object> model){
        Sotrudnik sotrudnik = null;
        try {
            sotrudnik = sotrudnikRepo.findById(sotrId).get();
            if (!sotrName.equals("")) {
                sotrudnik.setSotrName(sotrName);
            }
            if (!sotrEmail.equals("")) {
                sotrudnik.setSotrEmail(sotrEmail);
            }
            if (!sotrPhoneNumber.equals("")) {
                sotrudnik.setSotrPhoneNumber(sotrPhoneNumber);
            }
        }catch(Exception e)
        {

        }
        Iterable<Sotrudnik> sotrudniks =  sotrudnikRepo.findAll(); //Поиск всех пользователей в бд
        model.put("sotrudniks", sotrudniks);               //Вывод всех пользователей на страничку в списке
        return "sotr";
    }
}
