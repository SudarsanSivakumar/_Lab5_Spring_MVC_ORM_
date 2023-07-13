package com.example.tickettracker.p.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tickettracker.p.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
