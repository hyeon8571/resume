package com.example.resume.service;

import com.example.resume.dto.CertificateDto;
import com.example.resume.entity.Certificate;
import com.example.resume.repository.CertificateRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(readOnly = true)
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

    @Transactional
    public void writeCertificate(CertificateDto certificateDto) {

        try {
            certificateRepository.save(certificateDto.toEntity());
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("자격증 정보 저장 중 오류 발생");
        }
    }

    @Transactional
    public void deleteCertificate(Long id) {

        Certificate certificate = certificateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("자격증 정보를 찾지 못했습니다."));

        certificateRepository.delete(certificate);
    }
}
