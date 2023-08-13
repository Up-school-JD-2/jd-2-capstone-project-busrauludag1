package io.upschool.dto.request;

import io.upschool.entity.Company;
import io.upschool.entity.Route;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightRequest {

    @NotBlank(message = "Flight number shouldn't be blank.")
    @Size(min = 6, max = 6, message = "Flight number should be 6 character.")
    private String number;

    @Min(value = 10, message = "Seat capacity shouldn't be lower than 10")
    @Max(value = 300, message = "Seat capacity shouldn't be greater than 300")
    private Integer seatCapacity;

    @NotNull(message = "Company ID shouldn't be empty.")
    private Long companyId;

    @NotNull(message = "Route ID shouldn't be empty.")
    private Long routeId;
}
