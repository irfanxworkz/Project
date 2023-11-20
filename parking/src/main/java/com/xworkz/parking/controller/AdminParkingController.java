package com.xworkz.parking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.parking.dto.ParkingDTO;
import com.xworkz.parking.dto.ParkingInfoDTO;
import com.xworkz.parking.services.ParkingServices;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class AdminParkingController {

	@Autowired
	private ParkingServices parkingServices;

	public AdminParkingController() {
		log.info("Creating no arg Constructor Using ParkingController!!!");
	}

	@PostMapping(value = "/login")
	private String adminLogin(ParkingDTO dto, Model model, HttpServletRequest req) {
		log.info("Running findEmail method in ParkingController...");
		ParkingDTO dto1 = this.parkingServices.loginAdmin(dto.getEmail(), dto.getPassword());
		if (dto1 != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("dtos", dto1);
			return "/AdminDetails.jsp";
		} else {
			model.addAttribute("msg", "email or password invalid!!! ");
			return "/Admin.jsp";
		}
	}
	
	@PostMapping(value = "/info")
	private String addParkingInfo(ParkingInfoDTO parkingInfoDTO , Model model ) {
		
		model.addAttribute("add", parkingInfoDTO);
		
		parkingServices.adminSaveAndValidate(parkingInfoDTO);
		
		model.addAttribute("msg1", "Parking info added Successfully...");
		
		return "ParkingInfo.jsp";

	}
	
	@GetMapping(value = "/view")
	public String findByLocation(Model model,String location) {
		List<ParkingInfoDTO> list = parkingServices.findByLocationAdmin(location);
		model.addAttribute("list", list);
		return "/ViewData.jsp";

	}
}
