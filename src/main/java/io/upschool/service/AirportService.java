package io.upschool.service;

import io.upschool.dto.request.AirportRequest;
import io.upschool.dto.response.AirportResponse;
import io.upschool.entity.Airport;
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
        airport.setIsActive(true);
        return airportRepository.save(airport);
    }
}
