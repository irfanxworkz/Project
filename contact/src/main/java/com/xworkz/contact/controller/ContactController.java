package com.xworkz.contact.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.contact.constants.ContactConstant;
import com.xworkz.contact.dto.ContactDTO;
import com.xworkz.contact.services.ContactServices;

import lombok.extern.slf4j.Slf4j;

@Component
@RequestMapping("/")
@Slf4j
public class ContactController {
	
	private Set<ContactDTO> contactDTOs = new TreeSet<>();
	@Autowired
	private ContactServices contactServices;
	
	public ContactController() {
		log.info("Creating no-arg constructor Using ContactController!!!");
	}

	@PostMapping(value = "/send")
	private String onSend(ContactDTO dto, BindingResult bindingResult, Model model, MultipartFile file) throws IOException {
		//BindingResult used of All Error
		//MultipartFile uded of convert file to byte
		log.info("Running onSend Method ");
		
		model.addAttribute("dtos", dto);
		
		log.info("File received: "+file.getName());
		log.info("File Name: "+file.getOriginalFilename());
		log.info("File Size: "+file.getSize());
		log.info("File Type: "+file.getContentType());
		log.info("File bytes: "+file.getBytes());
		
		dto.setFileName(System.currentTimeMillis()+" _"+file.getOriginalFilename());
		dto.setContentType(file.getContentType());
		dto.setFileSize(file.getSize());
		
		contactServices.validateAndSave(dto);
		
		
		
		File physicalFile = new File(ContactConstant.FILE_LOCATION + dto.getFileName());
		
		try (OutputStream os = new FileOutputStream(physicalFile)) {
			os.write(file.getBytes());
		}
		
		contactDTOs.add(dto);
		log.info("Dto added to set, with total"+ contactDTOs.size());
		model.addAttribute("msg", " Application of " + dto.getName() + " for Contact is submitted successfully");
		
		return "/ContactDisplay.jsp";
	}
	
	/*
	@GetMapping("/fileDownload")
	public void sendImage(String fileName, String contentType, HttpServletResponse response) throws IOException {
		log.info("running sendImage method...");
		
		File file = new File(ContactConstant.FILE_LOCATION + fileName);
		response.setContentType(contentType);
		OutputStream outputStream = response.getOutputStream();
		FileInputStream in = new FileInputStream(file);
		byte[] buffer = new byte[4096];
		int length;
		while((length = in.read(buffer)) > 0) {
			outputStream.write(buffer, 0, length);
		}
		in.close();
		outputStream.flush();
	}
	*/
	
	@GetMapping("/Contactlist")
	public String showData(Model model) {
		log.info("running showData method...");
		model.addAttribute("dtos", contactDTOs);
		return "/ContactDetailsList.jsp";
	}
	
}
