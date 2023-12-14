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
    @Pattern(regexp = "^[가-힣]*$", message = "한글로 입력하세요.")
    private String name;

    @NotEmpty(message = "필수 입력 사항입니다.")
    private String job;

    @NotEmpty(message = "필수 입력 사항입니다.")
    @Pattern(regexp = "\\d{4}\\.\\d{2}\\.\\d{2}", message = "YYYY.MM.DD 형식으로 입력하세요")
    private String birth;

    @NotEmpty(message = "필수 입력 사항입니다.")
    @Pattern(regexp = "^\\d{3}-\\d{4}-\\d{4}$", message = "전화번호 양식에 맞지 않습니다.")
    private String phone_number;

    @NotEmpty(message = "필수 입력 사항입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]{2,12}@[a-zA-Z0-9]{2,6}\\.[a-zA-Z]{2,3}$", message = "이메일 형식이 잘못되었습니다.")
    private String email;

    @NotEmpty(message = "필수 입력 사항입니다.")
    private String address;

    public Profile toEntity() {
        return Profile.builder()
                .id(1L)
                .name(this.name)
                .job(this.job)
                .birth(this.birth)
                .phone_number(this.phone_number)
                .email(this.email)
                .address(this.address)
                .build();
    }
}
