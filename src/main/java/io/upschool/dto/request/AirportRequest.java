package io.upschool.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirportRequest {

    @NotBlank(message = "Name shouldn't be blank.")
    private String name;

    @NotBlank(message = "City shouldn't be blank.")
    private String city;

    @NotBlank(message = "Code shouldn't be blank.")
    @Size(min = 3, max = 3, message = "Code should be 3 character.")
    private String code;

}