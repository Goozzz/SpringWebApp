package com.example.kursachUD.controller;

import com.example.kursachUD.model.Usr;
import com.example.kursachUD.repo.UsrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UsrRepo usrRepo;

    @GetMapping("/user")
    public String main(Map<String, Object> model) {

        Iterable<Usr> users = usrRepo.findAll(); //Поиск всех пользователей в бд
        model.put("users", users);               //Вывод всех пользователей на страничку в списке
        return "user";
    }

    @PostMapping("addUser")
    public String addUser(@RequestParam String userName, @RequestParam String userEmail, Map<String, Object> model) {
        Usr user = new Usr(userName, userEmail);
        usrRepo.save(user);
        Iterable<Usr> users = usrRepo.findAll(); //Кусок необходим для обновления список с добавленными данными
        model.put("users", users);
        return "user";
    }

    @PostMapping("deleteUser")
    public String deleteUser(@RequestParam Integer userId, Map<String, Object> model) {
        Usr user = new Usr(userId);
        usrRepo.delete(user);
        Iterable<Usr> users = usrRepo.findAll(); //Кусок необходим для обновления список с добавленными данными
        model.put("users", users);
        return "user";
    }

    @PostMapping("updateUser")
    public String updateUser(@RequestParam Integer userId, @RequestParam String userName, @RequestParam String userEmail, Map<String, Object> model) {
        Usr user = null;
        try {
           user = usrRepo.findById(userId).get();
            if(!userEmail.equals("")) {
                user.setUserEmail(userEmail);
            }
            if(!userName.equals("")) {
                user.setUserName(userName);
            }

            usrRepo.save(user);
        } catch(Exception e) {

        }

        Iterable<Usr> users = usrRepo.findAll(); //Кусок необходим для обновления список с добавленными данными
        model.put("users", users);
        return "user";
    }
}