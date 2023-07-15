package com.xworkz.contact.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.contact.dto.ContactDTO;

import lombok.extern.slf4j.Slf4j;

@Component
@RequestMapping("/")
@Slf4j
public class ContactDefaultController {
	
	public ContactDefaultController() {
		log.info("Creating no-arg Constructor using ContactDefaultController!!!");
	}
	
	@GetMapping(value = "/contactStart")
	private String onStart(Model model) {
		model.addAttribute("dto", new ContactDTO());
		log.info("Running onStart Method In ContactDefaultController...");
		return "/ContactForm.jsp";
		
	}

}
