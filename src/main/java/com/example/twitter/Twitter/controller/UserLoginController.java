package com.example.twitter.Twitter.controller;


import com.example.twitter.Twitter.model.dto.UserCredentialsDto;
import com.example.twitter.Twitter.model.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

public class UserLoginController {

//    @Autowired
//    private LoginUserService service;
//
//    @GetMapping("/addloginuser")
//    public ModelAndView getLoginUserView(){
//        return new ModelAndView("addloginuser", "loginuser", new UserCredentialsDto());
//    }
//
//
//    @PostMapping("/addloginuser")
//    public String addLoginUser(@ModelAttribute @Valid UserCredentialsDto userCredentialsDto, BindingResult result){
//        service.addLoginUser(userCredentialsDto, result);
//        return "usersavedaccess";
//    }

}
