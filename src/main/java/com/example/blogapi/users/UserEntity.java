package com.example.blogapi.users;

import com.example.blogapi.common.baseEntity;
import jakarta.persistence.Entity;

@Entity
public class UserEntity extends baseEntity {


     String username;
     String email;
     String password; // TODO: hash this
     String bio;
     String image;


}
