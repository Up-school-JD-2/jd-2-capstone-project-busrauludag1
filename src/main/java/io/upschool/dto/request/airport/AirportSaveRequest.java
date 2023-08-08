package io.upschool.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class AirportSaveRequest {
    @NotBlank
    @Size(min = 2, max = 100)
    private String name;
    private String location;

}