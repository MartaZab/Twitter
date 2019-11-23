package com.example.twitter.Twitter.repository;

import com.example.twitter.Twitter.model.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginUserRepository extends JpaRepository<UserCredentials, Long> {
    Long countByLogin(String login);
}
