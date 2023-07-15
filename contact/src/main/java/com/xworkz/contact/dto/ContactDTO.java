package com.xworkz.contact.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class ContactDTO implements Serializable, Comparable<ContactDTO>{
	
	public ContactDTO() {
		log.info("Creating no-arg constructor using ContactDTO!!!");
	}
	
	private int id;
	
	private String name;
	
	private String email;
	
	private String mobile;
	
	private String comments;
	
	private String fileName;
	
	private String contentType;
	
	private long fileSize;

	@Override
	public int compareTo(ContactDTO o) {
		log.info("Running compareTo Method in ContactDTO...");
		return this.getName().compareTo(o.getName());
	}

}
