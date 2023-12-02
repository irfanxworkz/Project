package com.xworkz.parking.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.parking.dto.ParkingDTO;

import lombok.extern.slf4j.Slf4j;

@Component
@RequestMapping("/")
@Slf4j
public class ParkingDefaultController {

	public ParkingDefaultController() {
		log.info("Creating no-arg constructor Using ParkingDefaultController!!!");
	}
	//this method for Starting Home page Landing page */
	@GetMapping(value = "/parkingStart")
	private String home(Model model) {
		model.addAttribute("dto", "Running Landing Page Home Page");
		log.info("Running onStart Method in ParkingDefaultController...");
		return "/Home.jsp";
		

	}
}
