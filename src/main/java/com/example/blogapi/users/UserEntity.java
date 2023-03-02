package com.example.blogapi.users;

import com.example.blogapi.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;

@Entity(name = "user")
public class UserEntity extends BaseEntity {


     @Column(unique = true, nullable = false, length = 50)
     String username;
     String password; // TODO: hash this
     String bio;
     String image;


}
