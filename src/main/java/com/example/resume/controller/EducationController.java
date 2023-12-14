package com.example.resume.controller;

import com.example.resume.dto.EducationDto;
import com.example.resume.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5120")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EducationController {

    private final EducationService educationService;

    @PostMapping("/education")
    public ResponseEntity write(@Validated @RequestBody EducationDto educationDto) {

        educationService.writeEducation(educationDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/education")
    public ResponseEntity delete(@RequestParam Long id) {

        educationService.deleteEducation(id);

        return new ResponseEntity(HttpStatus.OK);
    }
}
