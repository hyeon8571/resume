package com.example.resume.service;

import com.example.resume.dto.MajorDto;
import com.example.resume.entity.Major;
import com.example.resume.repository.MajorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MajorService {

    private final MajorRepository majorRepository;

    public List<MajorDto> showMajors() {
        List<Major> majors = majorRepository.findAll();

        return majors
                .stream()
                .map(Major::toDto).toList();
    }

}
