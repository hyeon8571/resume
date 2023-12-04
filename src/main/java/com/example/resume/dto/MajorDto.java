package com.example.resume.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MajorDto {

    private Long id;

    private String name;

    private String grade;
}
