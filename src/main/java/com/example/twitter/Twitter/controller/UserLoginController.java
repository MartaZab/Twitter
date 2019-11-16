package com.example.twitter.Twitter.controller;


import com.example.twitter.Twitter.model.dto.LoginUserDto;
import com.example.twitter.Twitter.model.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserLoginController {

    @Autowired
    private LoginUserService service;

    @GetMapping("/addloginuser")
    public ModelAndView getLoginUserView(){
        return new ModelAndView("addloginuser", "loginuser", new LoginUserDto());
    }


    @PostMapping("/addloginuser")
    public String addLoginUser(@ModelAttribute @Valid LoginUserDto loginUser, BindingResult result){
        service.addLoginUser(loginUser, result);
        return "usersavedaccess";
    }

}
