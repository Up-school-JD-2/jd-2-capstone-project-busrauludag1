package io.upschool.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Flight {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "number", unique = true)
    private String number;

    @Column(name = "seat_capacity")
    private Integer seatCapacity;

    @Column(name = "available_seat")
    private Integer availableSeat;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private Route route;
}
