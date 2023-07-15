package com.xworkz.contact.repositry;

import com.xworkz.contact.entity.ContactEntity;

public interface ContactRepository {
	
	boolean save(ContactEntity entity);

}
