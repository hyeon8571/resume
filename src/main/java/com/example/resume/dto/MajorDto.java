package com.example.resume.dto;

import com.example.resume.entity.Major;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MajorDto {

    private Long id;

    @NotEmpty(message = "필수 입력 사항입니다.")
    private String name;

    @NotEmpty(message = "필수 입력 사항입니다.")
    @Pattern(regexp = "^[0-4](\\.[0-5])?$", message = "학점 양식에 맞지 않습니다.")
    private String grade;

    @NotEmpty(message = "필수 입력 사항입니다.")
    private String degree;

    public Major toEntity() {
        return Major.builder()
                .name(this.name)
                .grade(this.grade)
                .degree(this.degree)
                .build();
    }
}
