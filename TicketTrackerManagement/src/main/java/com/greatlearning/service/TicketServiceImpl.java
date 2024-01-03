package com.greatlearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.greatlearning.dao.TicketsRepository;
import com.greatlearning.entity.Tickets;

public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketsRepository ticketsRepository;
	
	@Override
	public List<Tickets> findAll() {
		// TODO Auto-generated method stub
		return ticketsRepository.findAll();
	}

	@Override
	public void save(Tickets tickets) {
		// TODO Auto-generated method stub
		ticketsRepository.save(tickets);
	}

	@Override
	public Tickets findById(int id) {
		// TODO Auto-generated method stub
		return ticketsRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		ticketsRepository.deleteById(id);
	}

	@Override
	public List<Tickets> getByKeyWord(String query) {
		// TODO Auto-generated method stub
		return ticketsRepository.findByKeyword(query);
	}

}
