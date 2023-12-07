package com.example.resume.service;

import com.example.resume.dto.RelatedActivityDto;
import com.example.resume.entity.RelatedActivity;
import com.example.resume.repository.RelatedActivityRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class RelatedActivityService {

    private final RelatedActivityRepository relatedActivityRepository;

    public List<RelatedActivityDto> showRelatedActivities() {
        List<RelatedActivity> relatedActivities = relatedActivityRepository.findAll();

        return relatedActivities
                .stream()
                .map(RelatedActivity::toDto).toList();
    }

    @Transactional
    public void writeRelatedActivity(RelatedActivityDto relatedActivityDto) {

        try {
            relatedActivityRepository.save(relatedActivityDto.toEntity());
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("관련활동 정보 저장 중 오류 발생");
        }
    }

    @Transactional
    public void deleteRelatedActivity(Long id) {

        RelatedActivity relatedActivity = relatedActivityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("관련활동 정보를 찾지 못했습니다."));

        relatedActivityRepository.delete(relatedActivity);
    }

}
