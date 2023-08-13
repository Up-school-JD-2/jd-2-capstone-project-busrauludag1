package io.upschool.dto.response;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerResponse {

    private Long id;

    private String tcNo;

    private String name;

    private String surname;

    private String mobileNumber;

    private Boolean isActive;

    private String creditCard;

}
