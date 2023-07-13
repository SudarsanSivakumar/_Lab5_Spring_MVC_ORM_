package com.example.tickettracker.p.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tickettracker.p.model.Ticket;
import com.example.tickettracker.p.service.TicketService;

//TicketController.java
@RestController
@RequestMapping("/tickets")
public class TicketController {
	private final TicketService ticketService;

	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@PostMapping
	public ResponseEntity<Ticket> createTicket(@RequestParam String title, @RequestParam String description,
			@RequestParam String status) {
		Ticket createdTicket = ticketService.createTicket(title, description, status);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdTicket);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
		Ticket ticket = ticketService.getTicketById(id);
		if (ticket != null) {
			return ResponseEntity.ok(ticket);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestParam String title,
			@RequestParam String description, @RequestParam String status) {
		Ticket updatedTicket = ticketService.updateTicket(id, title, description, status);
		if (updatedTicket != null) {
			return ResponseEntity.ok(updatedTicket);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
		boolean deleted = ticketService.deleteTicket(id);
		if (deleted) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
