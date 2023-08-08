package io.upschool.controller;

import io.upschool.dto.request.airport.AirportSaveRequest;
import io.upschool.dto.response.airport.AirportSaveResponse;
import io.upschool.dto.request.airport.AirportUpdateRequest;
import io.upschool.entity.Airport;
import io.upschool.service.AirportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @GetMapping
    public ResponseEntity<List<Airport>> getAirports() {
        var airports = airportService.getAllAirports();
        return ResponseEntity.status(HttpStatus.OK).body(airports);
    }

    @GetMapping("{name}")
    public ResponseEntity<List<Airport>> searchAirport(@PathVariable String name){
        List<Airport> response = airportService.searchByName(name);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<AirportSaveResponse> createAirport(@Valid @RequestBody AirportSaveRequest request) {
        var savedAirport = airportService.save(request);
        return ResponseEntity.ok(savedAirport);
    }

    @PutMapping
    public ResponseEntity<AirportSaveResponse> updateAirport(@RequestBody AirportUpdateRequest request) {
        var updatedAirport = airportService.update(request);
        return ResponseEntity.ok(updatedAirport);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAirport(@PathVariable("id") Long id) {
        ResponseEntity<?> response;
        try {
            airportService.delete(id);
            response = new ResponseEntity<>(null, null, HttpStatus.OK);
        } catch (Exception ex) {
            response = new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
        }
        return response;
    }


}
