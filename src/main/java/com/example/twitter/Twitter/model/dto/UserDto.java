package com.example.twitter.Twitter.model.dto;

import java.util.Date;

public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private Date joinDate;

    public UserDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public UserDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

}
