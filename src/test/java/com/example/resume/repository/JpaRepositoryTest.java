package com.example.resume.repository;

import com.example.resume.dto.CertificateDto;
import com.example.resume.entity.Certificate;
import com.example.resume.entity.Education;
import com.example.resume.entity.Major;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Jpa 연결 테스트")
@DataJpaTest
public class JpaRepositoryTest {

    private final CertificateRepository certificateRepository;

    private final EducationRepository educationRepository;

    private final MajorRepository majorRepository;

    private final ProfileRepository profileRepository;

    private final RelatedActivityRepository relatedActivityRepository;

    JpaRepositoryTest(
            @Autowired CertificateRepository certificateRepository,
            @Autowired EducationRepository educationRepository,
            @Autowired MajorRepository majorRepository,
            @Autowired ProfileRepository profileRepository,
            @Autowired RelatedActivityRepository relatedActivityRepository
    ) {
        this.certificateRepository = certificateRepository;
        this.educationRepository = educationRepository;
        this.majorRepository = majorRepository;
        this.profileRepository = profileRepository;
        this.relatedActivityRepository = relatedActivityRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void selectTest() {

        // Given

        // When
        List<Major> majors = majorRepository.findAll();
        List<Education> educations = educationRepository.findAll();

        // Then
        assertThat(majors).isNotNull().hasSize(1);
        assertThat(educations.get(0).toDto().getName()).isEqualTo("가천대학교");
    }

    @DisplayName("insert 테스트")
    @Test
    void insertTest() {

        // Given
        long previousCount = certificateRepository.count();
        //CertificateDto certificateDto = new CertificateDto(2L, "정보처리기사", "2024.03.20");
        //Certificate certificate = certificateDto.toEntity();


        // When
        //certificateRepository.save(certificate);

        // Then
        //assertThat(certificateRepository.count()).isEqualTo(previousCount + 1);
    }

}
