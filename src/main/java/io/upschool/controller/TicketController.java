package io.upschool.controller;

import io.upschool.entity.Ticket;
import io.upschool.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;
    @GetMapping
    public ResponseEntity<List<Ticket>> getTickets() {
        var tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }
    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketService.save(ticket));
    }


}
