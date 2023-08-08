package io.upschool.service;

import io.upschool.entity.Airport;
import io.upschool.entity.Passenger;
import io.upschool.repository.PassengerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class PassengerService {
    private final PassengerRepository passengerRepository;

    public Passenger save(Passenger passenger) {
        return passengerRepository.save(passenger);
    }


}

