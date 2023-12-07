package com.example.resume.dto;

import com.example.resume.entity.RelatedActivity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelatedActivityDto {

    private Long id;

    @NotEmpty(message = "필수 입력 사항입니다.")
    private String content;

    @NotEmpty(message = "필수 입력 사항입니다.")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}~\\d{4}-\\d{2}-\\d{2}$")
    private String period;

    public RelatedActivity toEntity() {
        return RelatedActivity.builder()
                .content(this.content)
                .period(this.period)
                .build();
    }
}
