package com.example.resume.service;

import com.example.resume.dto.responseDto.ResumeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final CertificateService certificateService;

    private final EducationService educationService;

    private final MajorService majorService;

    private final RelatedActivityService relatedActivityService;

    private final ProfileService profileService;

    public ResumeDto showResume() {

        return ResumeDto.builder()
                .profile(profileService.showProfile())
                .certificates(certificateService.showCertificates())
                .educations(educationService.showEducations())
                .relatedActivities(relatedActivityService.showRelatedActivities())
                .majors(majorService.showMajors())
                .build();
    }
}
