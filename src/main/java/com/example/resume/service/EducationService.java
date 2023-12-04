package com.example.resume.service;

import com.example.resume.dto.EducationDto;
import com.example.resume.entity.Education;
import com.example.resume.repository.EducationRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
