package com.example.twitter.Twitter.controller;

import com.example.twitter.Twitter.model.dto.PostDto;
import com.example.twitter.Twitter.model.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {

    @Autowired
    private PostService service;

    @RequestMapping("/posts")
    public ModelAndView postView(){
        return new ModelAndView("posts", "allPosts", service.getAllPosts());

    }

    @GetMapping("/addpost")
    public ModelAndView createNewPost(){
        return new ModelAndView("addpostform", "postToInsert", new PostDto());
    }

    @PostMapping("/addpost")
    public String addNewPost(@ModelAttribute PostDto post){
        System.out.println("Dodajemy nowy post na twitter " + post.getMessage());
        service.addPost(post);
        return "postsaved";
    }

//    @PostMapping("/deletepost")
//    public String deletePost(@ModelAttribute("post") PostDto post){
//        System.out.println(post.getId() + " " + post.getMessage());
//        service.deletePost(post);
//        return "index";
//    }

}
