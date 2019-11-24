package com.example.twitter.Twitter.repository;

import com.example.twitter.Twitter.model.entity.message.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
