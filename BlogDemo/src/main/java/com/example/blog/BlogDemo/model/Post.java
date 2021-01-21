package com.example.blog.BlogDemo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Entity
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column
    private String title;
    @Lob
    @NotEmpty
    @Column
    private String content;
    @Column
    private Instant createdOn;
    @Column
    private String updatedOn;
    @NotBlank
    @Column
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
