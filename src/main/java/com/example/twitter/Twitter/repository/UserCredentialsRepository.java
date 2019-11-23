package com.example.twitter.Twitter.repository;

import com.example.twitter.Twitter.model.entity.User;
import com.example.twitter.Twitter.model.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Long> {

    Optional<User> findByLogin(String login);
}

