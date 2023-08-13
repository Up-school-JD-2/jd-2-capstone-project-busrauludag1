package io.upschool.controller;

import io.upschool.dto.mapper.CompanyMapper;
import io.upschool.dto.request.AirportRequest;
import io.upschool.dto.request.CompanyRequest;
import io.upschool.dto.response.AirportResponse;
import io.upschool.dto.response.CompanyResponse;
import io.upschool.entity.Airport;
import io.upschool.entity.Company;
import io.upschool.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    private final CompanyMapper companyMapper;

    @PostMapping
    public ResponseEntity<CompanyResponse> createCompany(@Valid @RequestBody CompanyRequest request) {
        Company company = companyService.save(companyMapper.toCompany(request));
        return ResponseEntity.ok(companyMapper.toCompanyResponse(company));
    }

    @GetMapping("{id}")
    public ResponseEntity<CompanyResponse> getCompany(@PathVariable Long id){
        Company company = companyService.getById(id);
        return ResponseEntity.ok(companyMapper.toCompanyResponse(company));
    }
}
