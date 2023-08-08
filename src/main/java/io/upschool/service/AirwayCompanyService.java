package io.upschool.service;

import io.upschool.entity.Airport;
import io.upschool.entity.AirwayCompany;
import io.upschool.repository.AirwayCompanyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class AirwayCompanyService {
    private final AirwayCompanyRepository airwayCompanyRepository;

    public AirwayCompany save(AirwayCompany company) {
        return airwayCompanyRepository.save(company);
    }

}
