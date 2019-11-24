package com.example.twitter.Twitter.model.entity.user;


import javax.persistence.*;

@Entity
public class UserCredentials extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String role;

    public UserCredentials(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public UserCredentials() {
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }


    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }



}
