package com.example.resume.entity;

import com.example.resume.dto.EducationDto;
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
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String period;

    public EducationDto toDto() {

        return EducationDto.builder()
                .id(this.id)
                .name(this.name)
                .period(this.period)
                .build();
    }
}
