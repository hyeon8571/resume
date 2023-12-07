package com.example.resume.dto;

import com.example.resume.entity.Profile;
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

    @NotEmpty(message = "필수 입력 사항입니다.")
    @Pattern(regexp = "^[가-힣]*$")
    private String name;

    @NotEmpty(message = "필수 입력 사항입니다.")
    @Pattern(regexp = "^[0-9]+$")
    private Integer age;

    @NotEmpty(message = "필수 입력 사항입니다.")
    @Pattern(regexp = "^\\d{3}-\\d{4}-\\d{4}$")
    private String phone_number;

    @NotEmpty(message = "필수 입력 사항입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]{2,12}@[a-zA-Z0-9]{2,6}\\.[a-zA-Z]{2,3}$", message = "이메일 형식으로 작성해주세요")
    private String email;

    @NotEmpty(message = "필수 입력 사항입니다.")
    private String address;

    public Profile toEntity() {
        return Profile.builder()
                .name(this.name)
                .age(this.age)
                .phone_number(this.phone_number)
                .email(this.email)
                .address(this.address)
                .build();
    }
}
