package io.upschool.service;

import io.upschool.entity.Company;
import io.upschool.repository.CompanyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyService {
    private final CompanyRepository companyRepository;

    public Company save(Company company) {
        company.setIsActive(true);
        return companyRepository.save(company);
    }

    public Company getById(Long id) {
        return companyRepository.getReferenceById(id);
    }


}
