package com.example.resume.dto;

import com.example.resume.entity.Education;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {

    private Long id;

    @NotEmpty(message = "필수 입력 사항입니다.")
    private String name;

    @NotEmpty(message = "필수 입력 사항입니다.")
    @Pattern(regexp = "^\\d{4}.\\d{2}.\\d{2} ~ \\d{4}.\\d{2}.\\d{2}$", message = "YYYY.MM.DD ~ YYYY.MM.DD 형식으로 입력하세요")
    private String period;

    @NotEmpty(message = "필수 입력 사항입니다.")
    private String status;

    public Education toEntity() {
        return Education.builder()
                .name(this.name)
                .period(this.period)
                .status(this.status)
                .build();
    }
}
