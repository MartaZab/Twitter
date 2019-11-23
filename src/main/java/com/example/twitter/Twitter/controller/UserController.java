package com.example.twitter.Twitter.controller;

import com.example.twitter.Twitter.model.dto.UserCredentialsDto;
import com.example.twitter.Twitter.model.dto.UserDto;
import com.example.twitter.Twitter.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public ModelAndView userView(){
        return new ModelAndView("users", "allUsers", service.getAllUsers());
    }

    @GetMapping("/adduser")
    public ModelAndView createNewUser(){
        return new ModelAndView("adduserform", "userToInsert", new UserCredentialsDto());
    }

    @PostMapping("/adduser")
    public String addNewUser(@ModelAttribute UserCredentialsDto userCredentialsDto) {
        System.out.println("Dodajemy uzytkownika " + userCredentialsDto.getName() + " " + userCredentialsDto.getSurname());
        service.addUser(userCredentialsDto);
        return "redirect:index";
    }

//    @PostMapping("/deleteuser")
//    public String deleteUser(@ModelAttribute("user") UserDto user) {
//        service.deleteUser(user);
//        return "index";
//    }
}
