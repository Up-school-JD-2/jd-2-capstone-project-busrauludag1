package io.upschool.dto.request.ticket;

import io.upschool.entity.Passenger;

import java.time.LocalDateTime;

public class TicketSaveRequest {
    private Long passengerId;
    private Long flightId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Integer seatNumber;
    private Integer price;
}
