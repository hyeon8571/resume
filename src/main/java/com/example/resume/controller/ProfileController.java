package com.example.resume.controller;

import com.example.resume.dto.ProfileDto;
import com.example.resume.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "http://localhost:5120")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/profile")
    public ResponseEntity write(@Validated @RequestBody ProfileDto profileDto) {

        profileService.writeProfile(profileDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/profile")
    public ResponseEntity delete(@RequestParam Long id) {

        profileService.deleteProfile(id);

        return new ResponseEntity(HttpStatus.OK);
    }
}
