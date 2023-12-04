package com.example.resume.service;

import com.example.resume.dto.RelatedActivityDto;
import com.example.resume.entity.RelatedActivity;
import com.example.resume.repository.RelatedActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
