package com.example.resume.entity;

import com.example.resume.dto.CertificateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String acquisition_date; // 취득일

    public CertificateDto toDto() {
        return CertificateDto.builder()
                .id(this.id)
                .name(this.name)
                .acquisition_date(this.acquisition_date)
                .build();
    }
}
