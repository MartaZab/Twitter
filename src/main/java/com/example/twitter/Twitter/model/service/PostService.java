package com.example.twitter.Twitter.model.service;

import com.example.twitter.Twitter.model.dto.PostDto;
import com.example.twitter.Twitter.model.entity.user.User;
import com.example.twitter.Twitter.model.entity.message.Post;
import com.example.twitter.Twitter.repository.PostRepository;
import com.example.twitter.Twitter.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private int count = 0;

    public void addPost(PostDto postDto) {
        User user = userService.getLoggedUser();
        Post post = mapper.map(postDto, Post.class);
        post.setUser(user);
        System.out.println("Zmapowany post: " + post.getId()
                + " " + post.getMessage());
        postRepository.save(post);
    }

    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        for (Post p : posts) {
            System.out.println("Post: " + p.getId()
                    + " " + p.getMessage());
        }
        return posts.stream()
                .map(p -> mapper.map(p, PostDto.class))
                .collect(Collectors.toList());
    }

    public void deletePost(PostDto postDto) throws IllegalAccessException {
        Post post = postRepository.findById(postDto.getId()).get();
        if (post.getUser().getId() == userService.getLoggedUser().getId()) {
            postRepository.deleteById(postDto.getId());
        } else throw new IllegalAccessException("Nie mozesz usunac tego posta, nie jest Twój!");

    }

    public Post getPostById(Long id) throws Exception {
        if (postRepository.findById(id).isPresent()) {
            return postRepository.findById(id).get(); 
        } else throw new Exception("Nie ma takiego posta ");
    }
}
