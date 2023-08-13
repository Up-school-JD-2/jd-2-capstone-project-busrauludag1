package io.upschool.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerRequest {

    @NotBlank(message = "ID no shouldn't be blank.")
    @Pattern(regexp = "^([0-9]{11})$", message = "ID no should be 11 character.")
    private String tcNo;

    @NotBlank(message = "Name shouldn't be blank.")
    private String name;

    @NotBlank(message = "Surname shouldn't be blank.")
    private String surname;

    @NotBlank(message = "Name shouldn't be blank.")
    @Pattern(regexp = "^(05)([0-9]{2})\s?([0-9]{3})\s?([0-9]{2})\s?([0-9]{2})$", message = "Mobile number is wrong.")
    private String mobileNumber;

    @NotBlank(message = "Credit card number shouldn't be blank.")
    @Pattern(regexp = "^([0-9]{16}$|([0-9]{4}.[0-9]{4}.[0-9]{4}.[0-9]{4})$|([0-9]{4},[0-9]{4},[0-9]{4},[0-9]{4})$|([0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}))$", message = "Credit card is not valid.")
    private String creditCard;
}
