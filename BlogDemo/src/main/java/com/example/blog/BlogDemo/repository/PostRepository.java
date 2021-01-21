package com.example.blog.BlogDemo.repository;

import com.example.blog.BlogDemo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
