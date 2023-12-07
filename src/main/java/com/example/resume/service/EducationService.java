package com.example.resume.service;

import com.example.resume.dto.EducationDto;
import com.example.resume.entity.Certificate;
import com.example.resume.entity.Education;
import com.example.resume.repository.EducationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class EducationService {

    private final EducationRepository educationRepository;

    public List<EducationDto> showEducations() {
        List<Education> educations = educationRepository.findAll();

        return educations
                .stream()
                .map(Education::toDto).toList();
    }

    @Transactional
    public void writeEducation(EducationDto educationDto) {

        try {
            educationRepository.save(educationDto.toEntity());
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("학력 정보 저장 중 오류 발생");
        }
    }

    @Transactional
    public void deleteEducation(Long id) {
        Education education = educationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("학력 정보를 찾지 못했습니다."));

        educationRepository.delete(education);
    }
}
