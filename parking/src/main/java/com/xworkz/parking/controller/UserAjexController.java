package com.xworkz.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.xworkz.parking.dto.ParkingInfoDTO;
import com.xworkz.parking.services.ParkingServices;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/")
@RestController
@EnableWebMvc
@Slf4j
public class UserAjexController {
	
	@Autowired
	private ParkingServices parkingServices;
	
	@GetMapping(value = "validateFields/{location}/{type}/{classification}/{terms}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String validateFields(@PathVariable String location, @PathVariable String type,@PathVariable String classification,@PathVariable String terms, Model model) {
		/* log.info("running validateFields()..."); */
		ParkingInfoDTO parkingInfoDTO = parkingServices.findByLocationTypeClassificationTerm(location, type, classification, terms);
		/* log.info(" "+parkingInfoDTO); */
		if(parkingInfoDTO != null) {
			return "data is already exist";
		}
		return "";
	}
	
	@GetMapping(value = "/getPriceAndDiscount/{location}/{type}/{classification}/{terms}")
	public ParkingInfoDTO getPriceAndDiscount(@PathVariable String location, @PathVariable String type,@PathVariable String classification,@PathVariable String terms, Model model) {
		/* log.info("running validateFields()"); */
		ParkingInfoDTO parkingInfoDTO = parkingServices.findByLocationTypeClassificationTerm(location, type, classification, terms);
		/* log.info(" "+parkingInfoDTO); */
		if(parkingInfoDTO != null) {
			return parkingInfoDTO;
		}
		return null;
	}
	
	@GetMapping(value = "/validateEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String validateEmail(@PathVariable String email) {
		/* log.info("running validateEmail() in AjexController..."); */
		boolean exist = parkingServices.findByUserEmail(email);
		if(exist) {
			return "Email is already registered please login";
		}
		return "";
		
	}
}
