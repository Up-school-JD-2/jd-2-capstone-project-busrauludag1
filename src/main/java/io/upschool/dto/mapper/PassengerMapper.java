package io.upschool.dto.mapper;

import io.upschool.dto.request.PassengerRequest;
import io.upschool.dto.response.PassengerResponse;
import io.upschool.entity.Passenger;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(implementationName = "PassengerMapperImpl", componentModel = "spring")
public interface PassengerMapper {

    PassengerResponse toPassengerResponse(Passenger passenger);

    Passenger toPassenger(PassengerRequest passengerRequest);

}
