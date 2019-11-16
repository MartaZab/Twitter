package com.example.twitter.Twitter.repository;

import com.example.twitter.Twitter.model.entity.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {
    Long countByLogin(String login);
}
