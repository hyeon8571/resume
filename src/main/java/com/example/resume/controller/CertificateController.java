package com.example.resume.controller;

import com.example.resume.dto.CertificateDto;
import com.example.resume.service.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CertificateController {

    private final CertificateService certificateService;

    @PostMapping("/certificate")
    public ResponseEntity write(@Validated @RequestBody CertificateDto certificateDto) {

        certificateService.writeCertificate(certificateDto);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/certificate")
    public ResponseEntity delete(@RequestParam Long id) {

        certificateService.deleteCertificate(id);

        return new ResponseEntity(HttpStatus.OK);
    }
}
