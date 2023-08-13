package io.upschool.service;

import io.upschool.entity.Airport;
import io.upschool.entity.Passenger;
import io.upschool.entity.Route;
import io.upschool.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RouteService {
    private final RouteRepository routeRepository;

    @Transactional
    public Route save(Route route) {
        return routeRepository.save(route);
    }

    @Transactional(readOnly = true)
    public Route getById(Long id) {
        return routeRepository.getReferenceById(id);
    }

    public List<Route> getAll(){
        return routeRepository.findAll();
    }


}
