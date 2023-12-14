package com.example.resume.entity;

import com.example.resume.dto.ProfileDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String job;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false)
    private String phone_number;

    @Column(nullable = false)
    private String email;

    @Column
    private String address;

    public ProfileDto toDto() {
        return ProfileDto.builder()
                .id(this.id)
                .name(this.name)
                .job(this.job)
                .birth(this.birth)
                .phone_number(this.phone_number)
                .email(this.email)
                .address(this.address)
                .build();
    }

}
