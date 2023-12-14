package com.example.resume.controller;

import com.example.resume.dto.RelatedActivityDto;
import com.example.resume.service.RelatedActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5120")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RelatedActivityController {

    private final RelatedActivityService relatedActivityService;

    @PostMapping("/related-activity")
    public ResponseEntity write(@Validated @RequestBody RelatedActivityDto relatedActivityDto) {

        relatedActivityService.writeRelatedActivity(relatedActivityDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/related-activity")
    public ResponseEntity delete(@RequestParam Long id) {

        relatedActivityService.deleteRelatedActivity(id);

        return new ResponseEntity(HttpStatus.OK);
    }
}
