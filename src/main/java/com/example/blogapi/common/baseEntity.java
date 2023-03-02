package com.example.blogapi.common;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@MappedSuperclass
public class baseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @CreatedDate
    @Column(name = "createdAt", nullable = false, updatable = false)
    Date createdAt;
}
