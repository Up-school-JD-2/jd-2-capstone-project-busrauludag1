package io.upschool.service;

import io.upschool.dto.AirportSaveRequest;
import io.upschool.dto.AirportSaveResponse;
import io.upschool.entity.Airport;
import io.upschool.repository.AirportRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AirportService {
    private final AirportRepository airportRepository;


    public List<Airport> findAirportsByName(String name){
        return airportRepository.findAllByNameIs(name);
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public AirportSaveResponse save(AirportSaveRequest airportSaveRequest) {
        var airport = Airport.builder()
                                     .name(airportSaveRequest.getName())
                                     .location(airportSaveRequest.getLocation())
                                     .build();
        Airport savedAirport = airportRepository.save(airport);
        return AirportSaveResponse.builder()
                .id(savedAirport.getId())
                .nameAndLocation(savedAirport.getName() + " - " + savedAirport.getLocation())
                .build();
    }




}
