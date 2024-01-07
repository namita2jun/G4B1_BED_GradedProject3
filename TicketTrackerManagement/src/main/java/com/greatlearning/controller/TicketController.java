package com.greatlearning.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.entity.Tickets;
import com.greatlearning.service.TicketService;

@Controller
@RequestMapping("/admin")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/tickets/list")
	public String listTickets(Model model) {
		List<Tickets> tickets = ticketService.findAll();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = dateFormat.format(new Date());
		model.addAttribute("createdOn", dateString);
		model.addAttribute("tickets", tickets);
		return "tickets/list-tickets";

	}

	@GetMapping("/tickets/newTicket")
	public String createTicket(Model model) {
		Tickets ticket = new Tickets();
		model.addAttribute("ticket", ticket);
		return "tickets/create-ticket";

	}

	// public String saveBook(@RequetBody("book") Book theBook, Model model) {
	@PostMapping("/tickets/save")
	public String saveTicket(@ModelAttribute("ticket") Tickets theTickets) {
		// save the book object
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = dateFormat.format(new Date());
		theTickets.setCreatedOn(dateString);
		ticketService.save(theTickets);
		return "redirect:/admin/tickets/list";

	}

	@PostMapping("/tickets/delete")
	public String delete(@RequestParam("ticketId") int ticketId) {
		// delete the book
		ticketService.deleteById(ticketId);
		return "redirect:/admin/tickets/list";

	}

	@PostMapping("/tickets/showFormEdit")
	public String showFromForUpdate(@RequestParam("ticketId") int ticketId, Model model) {

		// get the book from the database
		Tickets theTicket = ticketService.findById(ticketId);
				
		// 1. theBook, ABC, JAV

		// 1. JAVA, JAVA, JAVA

		model.addAttribute("ticket", theTicket);
		return "tickets/update-ticket";

	}

	@PostMapping("/tickets/showFormView")
	public String showFromForView(@RequestParam("ticketId") int ticketId, Model model) {

		// get the book from the database
		Tickets theTicket = ticketService.findById(ticketId);
		// 1. theBook, ABC, JAVA

		// 1. JAVA, JAVA, JAVA

		model.addAttribute("ticket", theTicket);
		return "tickets/view-ticket";

	}

	@GetMapping({ "/", "/tickets/search" })
	public String home(Tickets ticket, Model model, String query) {
		if (query != null) {
			List<Tickets> tickets = ticketService.getByKeyWord(query);
			model.addAttribute("tickets", tickets);
		} else {
			List<Tickets> tickets = ticketService.findAll();
			model.addAttribute("tickets", tickets);
		}
		return "tickets/list-tickets";
	}
}
