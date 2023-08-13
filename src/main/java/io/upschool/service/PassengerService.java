package io.upschool.service;

import io.upschool.entity.Airport;
import io.upschool.entity.Flight;
import io.upschool.entity.Passenger;
import io.upschool.repository.PassengerRepository;
import io.upschool.util.StringUtil;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class PassengerService {
    private final PassengerRepository passengerRepository;


    public Passenger save(Passenger passenger) {
        passenger.setIsActive(true);
        String cleanCreditCard = StringUtil.cleanCreditCard(passenger.getCreditCard());
        String maskedCreditCard = StringUtil.maskCreditCard(cleanCreditCard);
        passenger.setCreditCard(maskedCreditCard);
        return passengerRepository.save(passenger);
    }

    @Transactional(readOnly = true)
    public Passenger getById(Long id) {
        return passengerRepository.getReferenceById(id);
    }

}

