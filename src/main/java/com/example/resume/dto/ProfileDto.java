package com.example.resume.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private Integer age;

    @NotEmpty
    private String phone_number;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9]{2,10}@[a-zA-Z0-9]{2,6}\\.[a-zA-Z]{2,3}$", message = "이메일 형식으로 작성해주세요")
    private String email;

    @NotEmpty
    private String address;
}
