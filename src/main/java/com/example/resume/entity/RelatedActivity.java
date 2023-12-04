package com.example.resume.entity;

import com.example.resume.dto.RelatedActivityDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelatedActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @Column
    private String period;

    public RelatedActivityDto toDto() {
        return RelatedActivityDto.builder()
                .id(this.id)
                .content(this.content)
                .period(this.period)
                .build();
    }
}
