package com.example.twitter.Twitter.model.dto;


public class CommentDto {

    private Long id;
    private UserDto user;
    private PostDto post;
    private String message;
    private Long postId;

    public CommentDto(PostDto post, String message) {
        this.post = post;
        this.message = message;
    }


    public CommentDto() {
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public PostDto getPost() {
        return post;
    }

    public void setPost(PostDto post) {
        this.post = post;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
