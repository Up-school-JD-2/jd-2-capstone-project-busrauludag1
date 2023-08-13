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

    @PostMapping
    public ResponseEntity<PassengerResponse> createPassenger(@Valid @RequestBody PassengerRequest passengerRequest) {
        Passenger passenger = passengerService.save(passengerMapper.toPassenger(passengerRequest));
        return ResponseEntity.status(HttpStatus.OK).body(passengerMapper.toPassengerResponse(passenger));
    }
}
