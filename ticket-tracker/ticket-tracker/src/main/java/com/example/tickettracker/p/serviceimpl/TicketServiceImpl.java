package com.example.tickettracker.p.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tickettracker.p.model.Ticket;
import com.example.tickettracker.p.repository.TicketRepository;
import com.example.tickettracker.p.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private final TicketRepository ticketRepository;

	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public Ticket createTicket(String title, String description, String status) {
		Ticket ticket = new Ticket(title, description, status);
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket getTicketById(Long id) {
		Optional<Ticket> optionalTicket = ticketRepository.findById(id);
		return optionalTicket.orElse(null);
	}

	@Override
	public Ticket updateTicket(Long id, String title, String description, String status) {
		Optional<Ticket> optionalTicket = ticketRepository.findById(id);
		if (optionalTicket.isPresent()) {
			Ticket ticket = optionalTicket.get();
			ticket.setTitle(title);
			ticket.setDescription(description);
			ticket.setStatus(status);
			return ticketRepository.save(ticket);
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteTicket(Long id) {
		Optional<Ticket> optionalTicket = ticketRepository.findById(id);
		if (optionalTicket.isPresent()) {
			ticketRepository.delete(optionalTicket.get());
			return true;
		} else {
			return false;
		}
	}
}
