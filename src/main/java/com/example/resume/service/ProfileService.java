package com.example.resume.service;

import com.example.resume.dto.ProfileDto;
import com.example.resume.entity.Profile;
import com.example.resume.repository.ProfileRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileDto showProfile() {
        Profile profile = profileRepository.findById(1L).
                orElseThrow(() -> new EntityNotFoundException("개인정보를 찾지 못했습니다."));

        return profile.toDto();
    }
}
