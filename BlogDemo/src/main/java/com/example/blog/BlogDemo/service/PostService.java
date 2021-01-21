package com.example.blog.BlogDemo.service;

import com.example.blog.BlogDemo.dto.PostDto;
import com.example.blog.BlogDemo.exception.PostNotFoundException;
import com.example.blog.BlogDemo.model.Post;
import com.example.blog.BlogDemo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class PostService {

    @Autowired
    private AuthService authService;
    @Autowired
    private PostRepository postRepository;

    public void createPost(PostDto postDto) {
        Post post = mapFromDtoToPost(postDto);
        postRepository.save(post);

    }

    public List<PostDto> showAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapFromPostToDto).collect(toList());
    }

    private PostDto mapFromPostToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setUserName(post.getUserName());
        return postDto;
    }

    private Post mapFromDtoToPost(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        User username = authService.getCurrentUser().orElseThrow(()-> new IllegalArgumentException("No user logged In"));
        post.setUserName(username.getUsername());
        post.setCreatedOn(Instant.now());
        return post;
    }

    public PostDto readSinglePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new PostNotFoundException("For ID" + id));
        return mapFromPostToDto(post);
    }
}
