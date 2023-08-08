package io.upschool.service;

import io.upschool.entity.Flight;
import io.upschool.entity.Passenger;
import io.upschool.entity.Ticket;
import io.upschool.repository.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketService {

    private final TicketRepository ticketRepository;
    private final FlightService flightService;
    private final PassengerService passengerService;


    public Ticket save (Ticket ticket) {
        Passenger passenger = passengerService.save(ticket.getPassenger());
        Flight flight = flightService.save(ticket.getFlight());
        //ticket.setPassenger(passenger);
        //ticket.setFlight(flight);
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
}
