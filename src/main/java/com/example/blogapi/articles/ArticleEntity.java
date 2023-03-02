package com.example.blogapi.articles;

import com.example.blogapi.common.BaseEntity;
import com.example.blogapi.users.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity(name = "articles")
public class ArticleEntity extends BaseEntity {

    @Column(name = "slug", nullable = false, length = 150)
    String slug;
    @Column(name = "title", nullable = false, length = 200)
    String title;
    String subtitle;
    @Column(nullable = false, length = 8000)
    String body;

    @ManyToOne
    UserEntity author;
}
