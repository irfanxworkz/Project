package com.xworkz.contact.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.contact.dto.ContactDTO;
import com.xworkz.contact.entity.ContactEntity;
import com.xworkz.contact.repositry.ContactRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContactServicesImpl implements ContactServices{

	@Autowired
	private ContactRepository repo;
	
	public ContactServicesImpl() {
		log.info("Creating no-arg Constructor Using ContactServicesImpl!!!");
	}

	@Override
	public boolean validateAndSave(ContactDTO dto) {
		log.info("Running validate and Save Method in ContactServicesImpl...");
		ContactEntity entity = new ContactEntity();
		BeanUtils.copyProperties(dto, entity);
		log.info("Entity Prints: "+entity);
		
		return this.repo.save(entity);
	}

}
