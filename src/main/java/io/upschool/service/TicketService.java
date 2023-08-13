package io.upschool.service;

import io.upschool.dto.request.TicketRequest;
import io.upschool.entity.Flight;
import io.upschool.entity.Passenger;
import io.upschool.entity.Route;
import io.upschool.entity.Ticket;
import io.upschool.exception.TicketAlreadySavedException;
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

    private boolean isTicketAlreadySaved(Ticket ticket){
        int ticketCountByTitle = ticketRepository.findTicketCountByTicketNumber(ticket.getNumber());
        return ticketCountByTitle > 0;
    }
    @Transactional
    public Ticket save(Ticket ticket) {
        if (ticket.getFlight().getAvailableSeat() == 0) {
            throw new RuntimeException("No seat available for this flight");
        } else if (isTicketAlreadySaved(ticket))
            throw new RuntimeException("This ticket is already purchased. Try again.");
        else {
            ticket.setIsActive(true);
            ticket.getFlight().setAvailableSeat(ticket.getFlight().getAvailableSeat() - 1);
            return ticketRepository.save(ticket);
        }
    }

    public Ticket getById(Long id) {
        return ticketRepository.getReferenceById(id);
    }

    public List<Ticket> getAll(){
        return ticketRepository.findAll();
    }

    public Ticket cancelTicket(String number) {
        Ticket ticket = ticketRepository.getTicketByNumber(number);
        ticket.setIsActive(false);
        ticket.getFlight().setAvailableSeat(ticket.getFlight().getAvailableSeat() + 1);
        return ticketRepository.save(ticket);
    }

}
