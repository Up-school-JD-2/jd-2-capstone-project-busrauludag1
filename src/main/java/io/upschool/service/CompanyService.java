package io.upschool.service;

import io.upschool.entity.Company;
import io.upschool.entity.Ticket;
import io.upschool.repository.CompanyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyService {
    private final CompanyRepository companyRepository;

    public Company save(Company company) {
        if(isCompanyAlreadySaved(company))
            throw new RuntimeException("This company is already saved.");
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
        Optional<Company> companyOpt = companyRepository.findById(id);
        if (companyOpt.isEmpty()) {
            throw new RuntimeException(id + " company ID is not found.");
        }
        return companyOpt.get();
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

}
