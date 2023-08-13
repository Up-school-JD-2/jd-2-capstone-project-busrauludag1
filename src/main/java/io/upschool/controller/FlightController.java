package io.upschool.controller;

import io.upschool.dto.mapper.CompanyMapper;
import io.upschool.dto.mapper.RouteMapper;
import io.upschool.dto.request.FlightRequest;
import io.upschool.dto.response.CompanyResponse;
import io.upschool.dto.response.FlightResponse;
import io.upschool.dto.response.RouteResponse;
import io.upschool.entity.Company;
import io.upschool.entity.Flight;
import io.upschool.entity.Route;
import io.upschool.service.CompanyService;
import io.upschool.service.FlightService;
import io.upschool.service.RouteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/flight")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    private final CompanyService companyService;

    private final RouteService routeService;

    private final CompanyMapper companyMapper;

    private final RouteMapper routeMapper;

    private FlightResponse getFlightResponse(Flight flight) {
        CompanyResponse companyResponse = companyMapper.toCompanyResponse(flight.getCompany());
        RouteResponse routeResponse = routeMapper.toRouteResponse(flight.getRoute());

        return FlightResponse.builder()
                .company(companyResponse)
                .route(routeResponse)
                .availableSeat(flight.getAvailableSeat())
                .seatCapacity(flight.getSeatCapacity())
                .id(flight.getId())
                .number(flight.getNumber())
                .isActive(flight.getIsActive())
                .build();
    }

    @PostMapping
    private ResponseEntity<FlightResponse> createFlight(@Valid @RequestBody FlightRequest flightRequest) {

        Company company = companyService.getById(flightRequest.getCompanyId());
        Route route = routeService.getById(flightRequest.getRouteId());

        Flight flight = Flight.builder()
                .company(company)
                .route(route)
                .seatCapacity(flightRequest.getSeatCapacity())
                .number(flightRequest.getNumber())
                .build();

        Flight savedFlight = flightService.save(flight);
        FlightResponse flightResponse = getFlightResponse(savedFlight);

        return ResponseEntity.ok(flightResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<FlightResponse> getFlight(@PathVariable Long id){
        Flight flight = flightService.getById(id);
        FlightResponse flightResponse = getFlightResponse(flight);
        return ResponseEntity.ok(flightResponse);
    }

    @GetMapping("/search/all")
    public ResponseEntity<List<FlightResponse>> getAllFlight() {
        List<Flight> flights = flightService.getAll();
        List<FlightResponse> flightResponses = new ArrayList<>();
        flights.forEach(flight -> {
            flightResponses.add(getFlightResponse(flight));
        });
        return ResponseEntity.ok(flightResponses);
    }

}
