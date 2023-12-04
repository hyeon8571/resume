package com.example.resume.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelatedActivityDto {

    private Long id;

    private String content;

    private String period;
}
