package com.example.resume.entity;

import com.example.resume.dto.MajorDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String grade;

    private  String degree;

    public MajorDto toDto() {
        return MajorDto.builder()
                .id(this.id)
                .name(this.name)
                .grade(this.grade)
                .degree(this.degree)
                .build();
    }

}
