package com.example.twitter.Twitter.model.dto;

import com.example.twitter.Twitter.model.entity.User;

public class PostDto {

    private Long id;
    private User user;
    private String message;


    public PostDto(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public PostDto() {
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
