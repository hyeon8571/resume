package com.example.resume.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {

    private Long id;

    private String name;

    private String period;
}
