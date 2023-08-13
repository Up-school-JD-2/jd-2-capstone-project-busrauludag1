package io.upschool.service;

import io.upschool.dto.request.CompanyRequest;
import io.upschool.entity.Company;
import io.upschool.exception.AirwayCompanyAlreadySavedException;
import io.upschool.repository.CompanyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyService {
    private final CompanyRepository companyRepository;

    public Company save(Company company) {
        if(isCompanyAlreadySaved(company))
            throw new AirwayCompanyAlreadySavedException("This company is already saved.");
        else {
            company.setIsActive(true);
            return companyRepository.save(company);
        }
    }

    public boolean isCompanyAlreadySaved(Company company) {
        int companyCountByName = companyRepository.findCompanyCountByName(company.getName());
        return companyCountByName > 0;
    }

    public Company getById(Long id) {
        return companyRepository.getReferenceById(id);
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

}
