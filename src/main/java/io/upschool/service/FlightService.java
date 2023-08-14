package io.upschool.service;

import io.upschool.entity.Company;
import io.upschool.entity.Flight;
import io.upschool.entity.Ticket;
import io.upschool.repository.FlightRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Flight getById(Long id) {
        Optional<Flight> flightOpt = flightRepository.findById(id);
        if (flightOpt.isEmpty()) {
            throw new RuntimeException(id + " flight ID is not found.");
        }
        return flightOpt.get();
    }

    public List<Flight> getAll() {
        return flightRepository.findAll();
    }
}
