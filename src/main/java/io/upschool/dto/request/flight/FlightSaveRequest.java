package io.upschool.dto.request.flight;

import io.upschool.entity.AirwayCompany;
import io.upschool.entity.Route;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class FlightSaveRequest {

    private String number;
    private Integer totalSeatNumber;
    private AirwayCompany company;
    private Route route;
}
