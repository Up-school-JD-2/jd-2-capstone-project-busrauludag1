package io.upschool.controller;

import io.upschool.dto.mapper.AirportMapper;
import io.upschool.dto.mapper.RouteMapper;
import io.upschool.dto.request.RouteRequest;
import io.upschool.dto.response.AirportResponse;
import io.upschool.dto.response.RouteResponse;
import io.upschool.entity.Airport;
import io.upschool.entity.Route;
import io.upschool.service.AirportService;
import io.upschool.service.RouteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/route")
@RequiredArgsConstructor
public class RouteController {
    private final RouteService routeService;

    private final AirportService airportService;

    private final AirportMapper airportMapper;

    private final RouteMapper routeMapper;

    private RouteResponse getRouteResponse(Route route) {
        AirportResponse departedAirportResponse = airportMapper.toAirportResponse(route.getDepartedAirport());
        AirportResponse arrivedAirportResponse = airportMapper.toAirportResponse(route.getArrivedAirport());

        return RouteResponse.builder()
                .arrivedAirport(arrivedAirportResponse)
                .departedAirport(departedAirportResponse)
                .id(route.getId())
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteResponse> getRoute(@PathVariable Long id) {
        Route route = routeService.getById(id);
        RouteResponse routeResponse = getRouteResponse(route);
        return ResponseEntity.status(HttpStatus.OK).body(routeResponse);
    }

    @GetMapping("/search/all")
    public ResponseEntity<List<RouteResponse>> getAllRoutes() {
        List<Route> routes = routeService.getAll();
        List<RouteResponse> routeResponses = new ArrayList<>();
        routes.forEach(route -> {
            routeResponses.add(routeMapper.toRouteResponse(route));
        });
        return ResponseEntity.status(HttpStatus.OK).body(routeResponses);
    }

    @PostMapping
    public ResponseEntity<RouteResponse> createRoute(@Valid @RequestBody RouteRequest routeRequest) {
        Airport departedAirport = airportService.getById(routeRequest.getDepartureId());
        Airport arrivedAirport = airportService.getById(routeRequest.getArrivalId());

        if (airportService.isAirportExist(departedAirport.getId()))
            throw new RuntimeException("There is no such airport ID for departure airport.");
        else if (airportService.isAirportExist(arrivedAirport.getId()))
            throw new RuntimeException("There is no such airport ID for arrival airport.");

        Route route = new Route();
        route.setArrivedAirport(arrivedAirport);
        route.setDepartedAirport(departedAirport);

        Route savedRoute = routeService.save(route);

        RouteResponse routeResponse = getRouteResponse(savedRoute);

        return ResponseEntity.status(HttpStatus.OK).body(routeResponse);
    }
}
