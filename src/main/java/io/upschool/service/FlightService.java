package io.upschool.service;

import io.upschool.entity.Flight;
import io.upschool.repository.FlightRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class FlightService {
    private final FlightRepository flightRepository;

    public Flight save(Flight flight) {
        flight.setIsActive(true);
        flight.setAvailableSeat(flight.getSeatCapacity());
        return flightRepository.save(flight);
    }

    @Transactional(readOnly = true)
    public Flight getById(Long id) {
        return flightRepository.getReferenceById(id);
    }

}
