package io.upschool.service;

import io.upschool.dto.request.AirportRequest;
import io.upschool.dto.response.AirportResponse;
import io.upschool.entity.Airport;
import io.upschool.entity.Company;
import io.upschool.entity.Passenger;
import io.upschool.repository.AirportRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AirportService {
    private final AirportRepository airportRepository;

    public Airport getById(Long id) {
        return airportRepository.getReferenceById(id);
    }

    public Airport save(Airport airport) {
        if(isAirportAlreadySaved(airport))
            throw new RuntimeException("This airport is already saved.");
        else {
            airport.setIsActive(true);
            return airportRepository.save(airport);
        }
    }

    public boolean isAirportAlreadySaved(Airport airport) {
        int airportCountByName = airportRepository.findAirportCountByName(airport.getName());
        return airportCountByName > 0;
    }

    public List<Airport> findAirportByCity(String city) {
        return airportRepository.findByCityContainingIgnoreCase(city);
    }

    public Airport findAirportByCode(String code) {
        return airportRepository.findByCode(code);
    }

    public List<Airport> getAll() {
        return airportRepository.findAll();
    }
}
