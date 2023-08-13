package io.upschool.dto.mapper;

import io.upschool.dto.request.AirportRequest;
import io.upschool.dto.response.AirportResponse;
import io.upschool.entity.Airport;
import org.mapstruct.Mapper;

@Mapper(implementationName = "AirportMapperImpl", componentModel = "spring")
public interface AirportMapper {

    Airport toAirport(AirportRequest airportRequest);

    AirportResponse toAirportResponse(Airport airport);

}
