package com.example.twitter.Twitter.controller;

import com.example.twitter.Twitter.model.dto.CommentDto;
import com.example.twitter.Twitter.model.dto.PostDto;
import com.example.twitter.Twitter.model.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CommentController {

@Autowired
    private CommentService service;

    @RequestMapping("/comments")
    public ModelAndView commentView(){
        return new ModelAndView("comments", "allComments", service.getAllComments());
    }

    @GetMapping("/addcomment")
    public String createNewCommentView(@ModelAttribute CommentDto comment){
        return "redirect:addcommentform?postId=" + comment.getPostId();
    }

    @GetMapping("/addcommentform")
    public String createNewComment(@ModelAttribute CommentDto comment, Model model){
        model.addAttribute("commentToInsert", comment);
        model.addAttribute("postId", comment.getPostId());
        return "addcommentform";
    }

    @PostMapping("/addcommentform")
    public String addNewComment(@ModelAttribute CommentDto comment) throws Exception {
        System.out.println("Dodajemy nowy komentarz " + comment.getMessage());
        service.addComment(comment);
        return "index";
    }

    @PostMapping("/deletecomment")
    public String deleteComment(@ModelAttribute("comment") CommentDto comment) throws IllegalAccessException {
        System.out.println(comment.getId() + " " + comment.getMessage());
        service.deleteComment(comment);
        return "redirect:comments";
    }

}


