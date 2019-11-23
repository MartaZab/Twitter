package com.example.twitter.Twitter.controller;

import com.example.twitter.Twitter.model.dto.CommentDto;
import com.example.twitter.Twitter.model.dto.PostDto;
import com.example.twitter.Twitter.model.service.CommentService;
import com.example.twitter.Twitter.model.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class CommentController {

    @Autowired
    private CommentService service;

    @RequestMapping("/comments")
    public ModelAndView commentView(){
        return new ModelAndView("comments", "allComments", service.getAllComments());

    }

    @GetMapping("/addcomment")
    public ModelAndView createNewComment(){
        return new ModelAndView("addcommentform", "commentToInsert", new PostDto());
    }

    @PostMapping("/addcomment")
    public String addNewComment(@ModelAttribute CommentDto comment){
        System.out.println("Dodajemy nowy komentarz " + comment.getMessage() + " do postu " + comment.getPost().getMessage());
        service.addComment(comment);
        return "commentsaved";
    }

//    @PostMapping("/deletepost")
//    public String deletePost(@ModelAttribute("post") PostDto post){
//        System.out.println(post.getId() + " " + post.getMessage());
//        service.deletePost(post);
//        return "index";
//    }

}


