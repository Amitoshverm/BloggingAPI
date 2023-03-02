package com.example.blogapi.users;

import com.example.blogapi.articles.ArticleEntity;
import com.example.blogapi.common.BaseEntity;
import jakarta.persistence.*;


import java.util.List;

@Entity(name = "user")
public class UserEntity extends BaseEntity {


     @Column(unique = true, nullable = false, length = 50)
     String username;
     String password; // TODO: hash this
     String bio;
     String image;
     @ManyToMany
     List<ArticleEntity> favorite;

     @ManyToMany
     @JoinTable(
             name = "user_follows",
             joinColumns = @JoinColumn(name = "follower_id"),
             inverseJoinColumns = @JoinColumn(name = "following_id")
     )
     List<UserEntity> following;

     @ManyToMany(mappedBy = "following")
     List<UserEntity> followers;

}
