package io.upschool.dto.request.airport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AirportUpdateRequest {
    private Long id;
    private String name;
    private String location;
}
