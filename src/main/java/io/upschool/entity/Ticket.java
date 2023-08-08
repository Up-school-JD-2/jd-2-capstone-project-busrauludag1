package io.upschool.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "tickets")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "number")
    private Long number;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "departed_time")
    private LocalDateTime startedTime;

    @Column(name = "arrived_time")
    private LocalDateTime finishTime;

    @Column(name = "price")
    private Integer price;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id")
    private Flight flight;

}
