package io.upschool.dto.mapper;

import io.upschool.dto.request.AirportRequest;
import io.upschool.dto.request.CompanyRequest;
import io.upschool.dto.response.CompanyResponse;
import io.upschool.entity.Company;
import io.upschool.dto.response.AirportResponse;
import io.upschool.entity.Airport;
import org.mapstruct.Mapper;

@Mapper(implementationName = "CompanyMapperImpl", componentModel = "spring")
public interface CompanyMapper {

    Company toCompany(CompanyRequest companyRequest);

    CompanyResponse toCompanyResponse(Company company);

}
