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
}
