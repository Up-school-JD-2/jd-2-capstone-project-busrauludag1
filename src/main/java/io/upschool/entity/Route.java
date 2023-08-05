package io.upschool.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "routes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Route {
    @Id
    @GeneratedValue
    private Long id;

    //@Column(name = "departed_arrived")
    //private Airport airport;

    //@Column(name = "arrived_airport")
    //private Airport arrivedAirport;

    @Column(name = "totalHour")
    private Integer totalHour;

    @Column(name = "is_active")
    private Boolean isActive;
}
