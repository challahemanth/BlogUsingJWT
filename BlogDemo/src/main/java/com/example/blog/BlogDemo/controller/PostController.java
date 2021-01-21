package com.example.blog.BlogDemo.controller;

import com.example.blog.BlogDemo.dto.PostDto;
import com.example.blog.BlogDemo.model.Post;
import com.example.blog.BlogDemo.service.AuthService;
import com.example.blog.BlogDemo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;


    @PostMapping
    public ResponseEntity createPost(@RequestBody PostDto postDto) {
        postService.createPost(postDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity <List<PostDto>> showAllPosts() {
        return new ResponseEntity(postService.showAllPosts(),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostDto> getSinglePost(@PathVariable @RequestBody Long id) {
        return new ResponseEntity(postService.readSinglePost(id),HttpStatus.OK);
    }


}
