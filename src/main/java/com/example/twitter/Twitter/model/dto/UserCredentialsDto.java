package com.example.twitter.Twitter.model.dto;

import javax.validation.constraints.Size;

    public class UserCredentialsDto extends UserDto {
        @Size(min = 3, max = 20, message = "login length should be between 3 and 20 characters.")
        private String login;
        @Size(min = 5, max = 20, message = "login length should be between 3 and 20 characters.")
        private String password;
        private String role;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

    }
