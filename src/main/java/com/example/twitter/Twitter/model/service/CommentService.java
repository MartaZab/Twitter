package com.example.twitter.Twitter.model.service;

import com.example.twitter.Twitter.model.dto.CommentDto;
import com.example.twitter.Twitter.model.entity.user.User;
import com.example.twitter.Twitter.model.entity.message.Comment;
import com.example.twitter.Twitter.repository.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostService postService;


    @Autowired
    private UserService userService;

    public void addComment(CommentDto commentDto){
        User user = userService.getLoggedUser();
        Comment comment = new Comment(commentDto.getMessage());
        comment.setUser(user);
        comment.setPost(postService.getPostById(commentDto.getPostId()));
        System.out.println("Zmapowany komentarz: "  + comment.getId()
                + " " + comment.getUser()
                + " " + comment.getMessage());
        commentRepository.save(comment);
    }

    public List<CommentDto> getAllComments(){
        List<Comment> comments = commentRepository.findAll();
        for (Comment c : comments) {
            System.out.println("Komentarz: " + c.getId()
                    + " " + c.getUser()
                    + " " + c.getMessage());
        }
        return comments.stream()
                .map(c -> mapper.map(c, CommentDto.class))
                .collect(Collectors.toList());
    }


    public void deleteComment(CommentDto commentDto) {
        commentRepository.deleteById(commentDto.getId());
    }
}

