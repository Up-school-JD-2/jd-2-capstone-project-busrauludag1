package io.upschool.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketRequest {

    @NotBlank(message = "Number shouldn't be blank.")
    private String number;

    @NotNull(message = "Passenger ID shouldn't be empty.")
    private Long passengerId;

    @NotNull(message = "Flight ID shouldn't be empty.")
    private Long flightId;

}
