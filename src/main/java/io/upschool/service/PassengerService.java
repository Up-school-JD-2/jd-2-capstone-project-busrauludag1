package io.upschool.service;

import io.upschool.entity.Airport;
import io.upschool.entity.Flight;
import io.upschool.entity.Passenger;
import io.upschool.repository.PassengerRepository;
import io.upschool.util.StringUtil;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PassengerService {
    private final PassengerRepository passengerRepository;

    @Transactional(readOnly = true)
    public Passenger save(Passenger passenger) {
        if (isPassengerAlreadySaved(passenger))
            throw new RuntimeException("This passenger is already saved.");
        else {
            passenger.setIsActive(true);
            String cleanCreditCard = StringUtil.cleanCreditCard(passenger.getCreditCard());
            String maskedCreditCard = StringUtil.maskCreditCard(cleanCreditCard);
            passenger.setCreditCard(maskedCreditCard);
            return passengerRepository.save(passenger);
        }
    }

    public boolean isPassengerAlreadySaved(Passenger passenger) {
        int passengerCountByTcNo = passengerRepository.findPassengerByCountByTcNo(passenger.getTcNo());
        return passengerCountByTcNo > 0;
    }

    public Passenger getById(Long id) {
        return passengerRepository.getReferenceById(id);
    }

    public List<Passenger> getAll(){
        return passengerRepository.findAll();
    }

}

