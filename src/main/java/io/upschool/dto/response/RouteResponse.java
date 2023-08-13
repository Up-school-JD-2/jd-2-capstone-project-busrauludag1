package io.upschool.dto.response;

import io.upschool.entity.Airport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RouteResponse {

    private Long id;

    private AirportResponse departedAirport;

    private AirportResponse arrivedAirport;

}
