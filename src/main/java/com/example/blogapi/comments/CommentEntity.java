package com.example.blogapi.comments;

import com.example.blogapi.articles.ArticleEntity;
import com.example.blogapi.common.BaseEntity;
import com.example.blogapi.users.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity(name = "comment")
public class CommentEntity extends BaseEntity {
    @Column(name="title", length = 100, nullable = false)
    String title;
    @Column(length=1000)
    String body;

    @ManyToOne
    ArticleEntity article;
    @ManyToOne
    UserEntity author;
}
