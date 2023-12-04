package com.example.resume.service;

import com.example.resume.dto.CertificateDto;
import com.example.resume.entity.Certificate;
import com.example.resume.repository.CertificateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CertificateService {

    private final CertificateRepository certificateRepository;

    public List<CertificateDto> showCertificates() {
        List<Certificate> certificates = certificateRepository.findAll();

        return certificates
                .stream()
                .map(Certificate::toDto).toList();
    }
}
