package com.example.twitter.Twitter.model.service;

import com.example.twitter.Twitter.model.dto.CommentDto;
import com.example.twitter.Twitter.model.message.Comment;
import com.example.twitter.Twitter.repository.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class CommentService {

//    @Autowired
//    private ModelMapper mapper;
//
//    @Autowired
//    private CommentRepository commentRepository;
//
//    public void addComment(CommentDto commentDto){
//        Comment comment = mapper.map(commentDto, Comment.class);
//        System.out.println("Zmapowany komentarz: "  + comment.getId()
//                + " " + comment.getUser()
//                + " " + comment.getMessage());
//        commentRepository.save(comment);
//    }
//
//    public List<CommentDto> getAllComments(){
//        List<Comment> comments = commentRepository.findAll();
//        for (Comment c : comments) {
//            System.out.println("Komentarz: " + c.getId()
//                    + " " + c.getUser()
//                    + " " + c.getMessage());
//        }
//        return comments.stream()
//                .map(c -> mapper.map(c, CommentDto.class))
//                .collect(Collectors.toList());
//    }
//
////    public void deletePost(PostDto postDto) {
////        postRepository.delete(postDto.getId());
////    }

}

