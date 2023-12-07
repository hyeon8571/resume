package com.example.resume.controller;

import com.example.resume.dto.MajorDto;
import com.example.resume.service.MajorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MajorController {

    private final MajorService majorService;

    @PostMapping("/major")
    public ResponseEntity write(@Validated @RequestBody MajorDto majorDto) {

        majorService.writeMajor(majorDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/major")
    public ResponseEntity delete(@RequestParam Long id) {

        majorService.deleteMajor(id);

        return new ResponseEntity(HttpStatus.OK);
    }
}
