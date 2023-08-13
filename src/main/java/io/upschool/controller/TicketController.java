package io.upschool.controller;

import io.upschool.dto.mapper.*;
import io.upschool.dto.request.TicketRequest;
import io.upschool.dto.response.*;
import io.upschool.entity.Flight;
import io.upschool.entity.Passenger;
import io.upschool.entity.Route;
import io.upschool.entity.Ticket;
import io.upschool.service.FlightService;
import io.upschool.service.PassengerService;
import io.upschool.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    private final PassengerService passengerService;

    private final FlightService flightService;
    private final PassengerMapper passengerMapper;

    private final CompanyMapper companyMapper;

    private final RouteMapper routeMapper;

    private TicketResponse getTicketResponse(Ticket ticket) {

        CompanyResponse companyResponse = companyMapper.toCompanyResponse(ticket.getFlight().getCompany());
        RouteResponse routeResponse = routeMapper.toRouteResponse(ticket.getFlight().getRoute());

        FlightResponse flightResponse = FlightResponse.builder()
                .company(companyResponse)
                .route(routeResponse)
                .availableSeat(ticket.getFlight().getAvailableSeat())
                .seatCapacity(ticket.getFlight().getSeatCapacity())
                .number(ticket.getFlight().getNumber())
                .id(ticket.getFlight().getId())
                .build();

        PassengerResponse passengerResponse = passengerMapper.toPassengerResponse(ticket.getPassenger());

        return TicketResponse.builder()
                .id(ticket.getId())
                .passenger(passengerResponse)
                .flight(flightResponse)
                .number(ticket.getNumber())
                .isActive(ticket.getIsActive())
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketResponse> getTicket(@PathVariable Long id) {
        Ticket ticket = ticketService.getById(id);
        TicketResponse ticketResponse = getTicketResponse(ticket);
        return ResponseEntity.status(HttpStatus.OK).body(ticketResponse);
    }

    @PostMapping
    public ResponseEntity<TicketResponse> createTicket(@RequestBody TicketRequest request) {

        Passenger passenger = passengerService.getById(request.getPassengerId());
        Flight flight = flightService.getById(request.getFlightId());

        Ticket ticket = new Ticket();
        ticket.setFlight(flight);
        ticket.setPassenger(passenger);
        ticket.setNumber(request.getNumber());

        Ticket savedTicket = ticketService.save(ticket);

        TicketResponse ticketResponse = getTicketResponse(savedTicket);

        return ResponseEntity.ok(ticketResponse);
    }

    @DeleteMapping("{number}")
    public ResponseEntity<TicketResponse> cancelTicket(@PathVariable String number) {
        Ticket cancelledTicket = ticketService.cancelTicket(number);
        TicketResponse ticketResponse = getTicketResponse(cancelledTicket);
        return ResponseEntity.ok(ticketResponse);
    }


}
