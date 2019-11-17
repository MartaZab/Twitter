package com.example.twitter.Twitter.repository;

import com.example.twitter.Twitter.model.message.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
