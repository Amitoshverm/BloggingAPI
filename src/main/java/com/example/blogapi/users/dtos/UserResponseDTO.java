package com.example.blogapi.users.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {


    Integer id;
    String email;
    String username;
    String bio;
    String image;
}
