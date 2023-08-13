package io.upschool.controller;

import io.upschool.dto.mapper.AirportMapper;
import io.upschool.dto.request.AirportRequest;
import io.upschool.dto.response.AirportResponse;
import io.upschool.entity.Airport;
import io.upschool.service.AirportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/airport")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    private final AirportMapper airportMapper;

    @PostMapping
    public ResponseEntity<AirportResponse> createAirport(@Valid @RequestBody AirportRequest request) {
        Airport airport = airportService.save(airportMapper.toAirport(request));
        return ResponseEntity.ok(airportMapper.toAirportResponse(airport));
    }

    @GetMapping("{id}")
    public ResponseEntity<AirportResponse> getAirport(@PathVariable Long id){
        Airport airport = airportService.getById(id);
        return ResponseEntity.ok(airportMapper.toAirportResponse(airport));
    }

    @GetMapping("/search/city/{city}")
    public ResponseEntity<List<AirportResponse>> searchAirportByCity(@PathVariable String city) {
        List<Airport> airports = airportService.findAirportByCity(city);
        List<AirportResponse> airportResponseList = new ArrayList<>();
        airports.forEach(airport -> {
            airportResponseList.add(airportMapper.toAirportResponse(airport));
        });
        return ResponseEntity.ok(airportResponseList);
    }

    @GetMapping("/search/code/{code}")
    public ResponseEntity<AirportResponse> searchAirportByCode(@PathVariable String code) {
        Airport airport = airportService.findAirportByCode(code);
        return ResponseEntity.ok(airportMapper.toAirportResponse(airport));
    }

    @GetMapping("/search/all")
    public ResponseEntity<List<AirportResponse>> getAllAirports() {
        List<Airport> airports = airportService.getAll();
        List<AirportResponse> airportResponses = new ArrayList<>();
        airports.forEach(airport -> {
            airportResponses.add(airportMapper.toAirportResponse(airport));
        });
        return ResponseEntity.ok(airportResponses);
    }

}
