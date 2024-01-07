package com.greatlearning.service;

import java.util.List;

import com.greatlearning.entity.Tickets;

public interface TicketService {

	public List<Tickets> findAll();

	public void save(Tickets tickets);

	public Tickets findById(int id);

	public void deleteById(int id);

	public List<Tickets> getByKeyWord(String query);

}
