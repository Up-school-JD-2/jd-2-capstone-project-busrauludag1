package io.upschool.dto;

import io.upschool.entity.Passenger;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TicketSaveDto {
    private Passenger passenger;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Integer price;
}
