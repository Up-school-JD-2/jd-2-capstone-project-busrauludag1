package io.upschool.dto.request;

import io.upschool.entity.Airport;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RouteRequest {

    @NotNull(message = "Departure ID shouldn't be empty.")
    private Long departureId;

    @NotNull(message = "Arrival ID shouldn't be empty.")
    private Long arrivalId;

}
