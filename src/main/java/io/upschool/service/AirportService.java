package io.upschool.service;

import io.upschool.dto.request.airport.AirportSaveRequest;
import io.upschool.dto.response.airport.AirportSaveResponse;
import io.upschool.dto.request.airport.AirportUpdateRequest;
import io.upschool.entity.Airport;
import io.upschool.repository.AirportRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AirportService {
    private final AirportRepository airportRepository;

    public List<Airport> findAirportsByName(String name){
        return airportRepository.findAllByNameIs(name);
    }

    public List<Airport> searchByName(String name) {
        List<Airport> response = airportRepository.findByNameContainingIgnoreCase(name);
        return response;
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

    public AirportSaveResponse update(AirportUpdateRequest airportUpdateRequest) {
        var optionalAirport = airportRepository.findById(airportUpdateRequest.getId());
        if (optionalAirport.isPresent()) {
            var airport = optionalAirport.get();
            airport.setName(airportUpdateRequest.getName());
            airport.setLocation(airportUpdateRequest.getLocation());
            airport = airportRepository.save(airport);
            return AirportSaveResponse.builder()
                    .nameAndLocation(airport.getName() + " - " + airport.getLocation())
                    .id(airport.getId())
                    .build();
        }
        throw new RuntimeException("Airport not found!");
    }

    public Airport delete(Long id) {
        Optional<Airport> airportOpt = airportRepository.findById(id);
        if (airportOpt.isEmpty()) {
            throw new RuntimeException("Airport not found.");
        } else {

            airportOpt.get().setIsActive(false);
            airportRepository.save(airportOpt.get());
            //airportRepository.deleteById(id);  // hard delete
            return airportOpt.get();
        }
    }


}
