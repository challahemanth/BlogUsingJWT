package com.example.blog.BlogDemo.exception;

public class PostNotFoundException extends RuntimeException{

    public PostNotFoundException(String message) {
        super(message);
    }

}
