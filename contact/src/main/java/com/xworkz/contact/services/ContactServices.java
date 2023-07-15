package com.xworkz.contact.services;

import com.xworkz.contact.dto.ContactDTO;

public interface ContactServices {
	
	boolean validateAndSave(ContactDTO dto);

}
