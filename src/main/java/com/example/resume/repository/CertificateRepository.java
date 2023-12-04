package com.example.resume.repository;

import com.example.resume.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}
