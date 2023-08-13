package io.upschool.dto.response;

import io.upschool.entity.Company;
import io.upschool.entity.Route;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightResponse {

    private Long id;

    private String number;

    private Integer seatCapacity;

    private Integer availableSeat;

    private CompanyResponse company;

    private RouteResponse route;

}
