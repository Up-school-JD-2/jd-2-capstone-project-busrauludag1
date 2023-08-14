package io.upschool.service;

import io.upschool.entity.Airport;
import io.upschool.entity.Passenger;
import io.upschool.entity.Route;
import io.upschool.entity.Ticket;
import io.upschool.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RouteService {
    private final RouteRepository routeRepository;

    @Transactional
    public Route save(Route route) {
        return routeRepository.save(route);
    }
    public Route getById(Long id) {
        Optional<Route> ticketOpt = routeRepository.findById(id);
        if (ticketOpt.isEmpty()) {
            throw new RuntimeException(id + " route ID is not found.");
        }
        return ticketOpt.get();
    }

    public List<Route> getAll(){
        return routeRepository.findAll();
    }


}
