package com.example.resume.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificateDto {

    private Long id;

    private String name;

    private String acquisition_date;
}
