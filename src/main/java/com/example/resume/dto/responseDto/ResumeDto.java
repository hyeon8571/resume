package com.example.resume.dto.responseDto;

import com.example.resume.dto.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResumeDto {

    private ProfileDto profile;

    private List<CertificateDto> certificates;

    private List<EducationDto> education;

    private List<RelatedActivityDto> relatedActivities;

    private MajorDto major;

}
