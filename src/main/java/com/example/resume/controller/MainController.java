package com.example.resume.controller;

import com.example.resume.dto.responseDto.ResumeDto;
import com.example.resume.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5120")
@RestController
@RequiredArgsConstructor
public class MainController {

    private final ResumeService resumeService;

    @GetMapping("/")
    public ResponseEntity<ResumeDto> mainPage() {

        ResumeDto resume = resumeService.showResume();

        return ResponseEntity.status(HttpStatus.OK).body(resume);
    }
}
