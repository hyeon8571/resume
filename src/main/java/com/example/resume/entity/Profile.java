package com.example.resume.entity;

import jakarta.persistence.*;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private Integer age;

    @Column(nullable = false)
    private String phone_number;

    @Column(nullable = false)
    private String email;

    @Column
    private String address;

}
