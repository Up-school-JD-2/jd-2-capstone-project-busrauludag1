package io.upschool.service;

import io.upschool.entity.Company;
import io.upschool.entity.Flight;
import io.upschool.repository.FlightRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FlightService {
    private final FlightRepository flightRepository;

    public Flight save(Flight flight) {
        if (isFlightAlreadySaved(flight))
            throw new RuntimeException("This flight is already saved.");
        else {
            flight.setIsActive(true);
            flight.setAvailableSeat(flight.getSeatCapacity());
            return flightRepository.save(flight);
        }
    }

    public boolean isFlightAlreadySaved(Flight flight) {
        int flightCountByName = flightRepository.findFlightCountByNumber(flight.getNumber());
        return flightCountByName > 0;
    }

    @Transactional(readOnly = true)
    public Flight getById(Long id) {
        return flightRepository.getReferenceById(id);
    }

    public List<Flight> getAll() {
        return flightRepository.findAll();
    }
}
