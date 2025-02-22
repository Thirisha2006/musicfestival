package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Ticket;
import com.example.demo.repository.TicketRepository;

@Service
public class TicketService {

     @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public Ticket getTicketByTicketNumber(String ticketNumber) {
        return ticketRepository.findByTicketNumber(ticketNumber);
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        return ticketRepository.findById(id).map(ticket -> {
            ticket.setEventName(updatedTicket.getEventName());
            ticket.setUserName(updatedTicket.getUserName());
            ticket.setTicketNumber(updatedTicket.getTicketNumber());
            ticket.setSeatNumber(updatedTicket.getSeatNumber());
            ticket.setPrice(updatedTicket.getPrice());
            ticket.setStatus(updatedTicket.getStatus());
            return ticketRepository.save(ticket);
        }).orElse(null);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
