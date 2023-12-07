package com.example.resume.dto;

import com.example.resume.entity.Certificate;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificateDto {

    private Long id;

    @NotEmpty(message = "필수 입력 사항입니다.")
    private String name;

    @NotEmpty(message = "필수 입력 사항입니다.")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
    private String acquisition_date;

    public Certificate toEntity() {
        return Certificate.builder()
                .name(this.name)
                .acquisition_date(this.acquisition_date)
                .build();
    }
}
