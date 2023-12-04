package com.example.resume.dto.responseDto;

import com.example.resume.dto.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeDto {

    private ProfileDto profile;

    private List<CertificateDto> certificates;

    private List<EducationDto> educations;

    private List<RelatedActivityDto> relatedActivities;

    private List<MajorDto> majors;

}
