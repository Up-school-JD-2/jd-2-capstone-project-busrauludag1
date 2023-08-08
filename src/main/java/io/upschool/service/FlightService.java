package io.upschool.service;

import io.upschool.entity.Flight;
import io.upschool.repository.FlightRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class FlightService {
    private final FlightRepository flightRepository;
    private final AirwayCompanyService airwayCompanyService;

    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }


}
