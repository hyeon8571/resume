package com.example.resume.entity;

import jakarta.persistence.*;

@Entity
public class RelatedActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @Column
    private String period;
}
