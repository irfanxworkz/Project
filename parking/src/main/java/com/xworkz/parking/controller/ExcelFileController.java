package com.xworkz.parking.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.parking.services.ExcelService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class ExcelFileController {
	
	@Autowired
    ExcelService excelService;
	
    @PostMapping("/uploadExcelFile")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
    	log.info("Running handleFileUpload");
	    if(!file.isEmpty()) {
	    	try {	//Get the bytes from the file
	                byte[] bytes = file.getBytes();
	                String directory = "C:\\Users\\irfan khan\\OneDrive\\Desktop\\x-workz\\Upload File";
	                Path path = Paths.get(directory, file.getOriginalFilename());
	                log.info("Original file name is : "+file.getOriginalFilename());
	                Files.write(path, bytes);
	                log.info("file saved successfully...");
	                boolean status=this.excelService.saveParkingThrowExcel(file);
	                if(status) {
	                	model.addAttribute("messageSucess", "Data Uploaded successfully in Database.");
	                }else {
						model.addAttribute("ErrorSucess","Data not store in database something went wrong.");
					}   
	            } catch (IOException e){
	                	e.printStackTrace();
	                log.info("message :"+e);
	            }
	       } else {
	             model.addAttribute("ErrorFile", "Please select a file to upload.");
	             log.info("please select a file");
	        }
	        	return "/ExcelFileForBulk.jsp";
    	}
  }