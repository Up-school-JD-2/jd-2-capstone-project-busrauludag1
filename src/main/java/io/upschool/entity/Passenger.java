package io.upschool.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "passengers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Passenger {
    @Id
    @GeneratedValue
    private Long id;

    @Pattern(regexp = "^[1-9][0-9]{9}[02468]$")
    @Column(name = "tc_no")
    private String tcNo;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Pattern(regexp = "^(05)([0-9]{2})\s?([0-9]{3})\s?([0-9]{2})\s?([0-9]{2})$")
    @Column(name = "mobile")
    private String mobileNumber;

    @Column(name = "is_active")
    private Boolean isActive;

    @Pattern(regexp = "^([0-9]{4})\s?([0-9]{4})\s?([0-9]{4})\s?([0-9]{2})$")
    @Column(name = "credit_card")
    private String creditCard;

}
