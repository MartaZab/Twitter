package com.example.twitter.Twitter.repository;

import com.example.twitter.Twitter.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
