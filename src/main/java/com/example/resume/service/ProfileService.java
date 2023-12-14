package com.example.resume.service;

import com.example.resume.dto.ProfileDto;
import com.example.resume.entity.Profile;
import com.example.resume.repository.ProfileRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileDto showProfile() {

        try {
            Profile profile = profileRepository.findById(1L).
                    orElseThrow(() -> new EntityNotFoundException("개인정보를 찾지 못했습니다."));

            return profile.toDto();
        } catch (EntityNotFoundException e) {
            return new ProfileDto();
        }

    }

    @Transactional
    public void writeProfile(ProfileDto profileDto) {

        try {
            profileRepository.save(profileDto.toEntity());
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("개인정보 저장 중 오류 발생");
        }
    }

    @Transactional
    public void deleteProfile(Long id) {

        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("개인정보를 찾지 못했습니다."));

        profileRepository.delete(profile);
    }
}
