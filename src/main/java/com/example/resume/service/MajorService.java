package com.example.resume.service;

import com.example.resume.dto.MajorDto;
import com.example.resume.entity.Major;
import com.example.resume.repository.MajorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
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

    @Transactional
    public void writeMajor(MajorDto majorDto) {

        try {
            majorRepository.save(majorDto.toEntity());
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("전공 정보 저장 중 오류 발생");
        }
    }

    @Transactional
    public void deleteMajor(Long id) {

        Major major = majorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("전공 정보를 찾지 못했습니다."));

        majorRepository.delete(major);

    }
}

