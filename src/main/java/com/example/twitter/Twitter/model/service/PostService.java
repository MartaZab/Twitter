package com.example.twitter.Twitter.model.service;

import com.example.twitter.Twitter.model.dto.PostDto;
import com.example.twitter.Twitter.model.message.Post;
import com.example.twitter.Twitter.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PostRepository postRepository;

    public void addPost(PostDto postDto){
        Post post = mapper.map(postDto, Post.class);
        System.out.println("Zmapowany post: "  + post.getId()
                + " " + post.getMessage());
        postRepository.save(post);
    }

    public List<PostDto> getAllPosts(){
        List<Post> posts = postRepository.findAll();
        for (Post p : posts) {
            System.out.println("Post: " + p.getId()
                    + " " + p.getMessage());
        }
        return posts.stream()
                .map(p -> mapper.map(p, PostDto.class))
                .collect(Collectors.toList());
    }

//    public void deletePost(PostDto postDto){
//        postRepository.delete(postDto.getId());
//
//    }

}
