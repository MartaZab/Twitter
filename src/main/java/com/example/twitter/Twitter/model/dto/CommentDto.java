package com.example.twitter.Twitter.model.dto;

import com.example.twitter.Twitter.model.entity.User;
import com.example.twitter.Twitter.model.message.Post;

public class CommentDto {

    private Long id;
    private User user;
    private Post post;
    private String message;

    public CommentDto(Post post, String message) {
        this.post = post;
        this.message = message;
    }


    public CommentDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
