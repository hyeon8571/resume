package com.example.resume.restController;

import com.example.resume.dto.responseDto.ResumeDto;
import com.example.resume.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final ResumeService resumeService;

    @GetMapping("/")
    public ResponseEntity<ResumeDto> mainPage() {

        ResumeDto resume = resumeService.showResume();

        return
    }
}
