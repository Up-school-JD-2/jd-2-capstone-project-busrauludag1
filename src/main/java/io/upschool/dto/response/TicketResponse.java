package io.upschool.dto.response;

import io.upschool.entity.Flight;
import io.upschool.entity.Passenger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketResponse {

    private Long id;

    private String number;

    private PassengerResponse passenger;

    private FlightResponse flight;

    private Boolean isActive;

}
