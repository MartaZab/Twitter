package com.example.twitter.Twitter.controller;

import com.example.twitter.Twitter.model.dto.CommentDto;
import com.example.twitter.Twitter.model.dto.PostDto;
import com.example.twitter.Twitter.model.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class CommentController {
//
//    @Autowired
//    private CommentService service;
//
//    @RequestMapping("/comments")
//    public ModelAndView commentView(){
//        return new ModelAndView("comments", "allComments", service.getAllComments());
//
//    }
//
//    @GetMapping("/addcomment")
//    public ModelAndView createNewComment(){
//        return new ModelAndView("addcommentform", "commentToInsert", new PostDto());
//    }
//
//    @PostMapping("/addcomment")
//    public String addNewComment(@ModelAttribute CommentDto comment){
//        System.out.println("Dodajemy nowy komentarz " + comment.getMessage() + " do postu " + comment.getPost().getMessage());
//        service.addComment(comment);
//        return "commentsaved";
//    }
//
////    @PostMapping("/deletecomment")
////    public String deleteComment(@ModelAttribute("comment") CommentDto comment){
////        System.out.println(comment.getId() + " " + comment.getMessage());
////        service.deleteComment(comment);
////        return "index";
////    }
////
//}


