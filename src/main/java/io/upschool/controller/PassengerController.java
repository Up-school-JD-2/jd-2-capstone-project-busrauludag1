package io.upschool.controller;

import io.upschool.dto.mapper.PassengerMapper;
import io.upschool.dto.request.PassengerRequest;
import io.upschool.dto.response.PassengerResponse;
import io.upschool.entity.Passenger;
import io.upschool.service.PassengerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/passenger")
@RequiredArgsConstructor
public class PassengerController {

    private final PassengerService passengerService;

    private final PassengerMapper passengerMapper;

    @GetMapping("/{id}")
    public ResponseEntity<PassengerResponse> getPassenger(@PathVariable Long id) {
        Passenger passenger = passengerService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(passengerMapper.toPassengerResponse(passenger));
    }

    @GetMapping("/search/all")
    public ResponseEntity<List<PassengerResponse>> getAllPAssengers() {
        List<Passenger> passengers = passengerService.getAll();
        List<PassengerResponse> passengerResponses = new ArrayList<>();
        passengers.forEach(passenger -> {
            passengerResponses.add(passengerMapper.toPassengerResponse(passenger));
        });

        return ResponseEntity.status(HttpStatus.OK).body(passengerResponses);
    }

    @PostMapping
    public ResponseEntity<PassengerResponse> createPassenger(@Valid @RequestBody PassengerRequest passengerRequest) {
        Passenger passenger = passengerService.save(passengerMapper.toPassenger(passengerRequest));
        return ResponseEntity.status(HttpStatus.OK).body(passengerMapper.toPassengerResponse(passenger));
    }
}
