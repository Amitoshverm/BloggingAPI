package com.example.blogapi.articles;

import com.example.blogapi.users.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class createArticleDTO {

    String slug;
    String title;
    String body;
    UserEntity author;

}
