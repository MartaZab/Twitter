package com.example.twitter.Twitter.controller;

import com.example.twitter.Twitter.model.dto.UserDto;
import com.example.twitter.Twitter.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/users")

    public ModelAndView userView(){
        return new ModelAndView("users", "allUsers", service.getAllUsers());
    }

    @GetMapping("/adduser")
    public ModelAndView createNewUser(){
        return new ModelAndView("adduserform", "userToInsert", new UserDto());
    }

    @PostMapping("/adduser")
    public String addNewUser(@ModelAttribute UserDto user) {
        System.out.println("Dodajemy uzytkownika " + user.getName() + " " + user.getSurname());
        service.addUser(user);
        return "usersavedaccess";
    }

//    @PostMapping("/deleteuser")
//    public String deleteUser(@ModelAttribute("user") UserDto user) {
//        service.deleteUser(user);
//        return "index";
//    }
}
