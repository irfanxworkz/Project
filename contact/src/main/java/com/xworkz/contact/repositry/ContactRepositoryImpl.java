package com.xworkz.contact.repositry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.contact.entity.ContactEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ContactRepositoryImpl implements ContactRepository{

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	public ContactRepositoryImpl() {
		log.info("Creating no-arg Constructor Using ContactRepositoryImpl!!!");
	}
	
	@Override
	public boolean save(ContactEntity entity) {
		EntityManager manager=null;
		EntityTransaction transaction = null;
		try {
		 manager = entityManagerFactory.createEntityManager();
		 transaction = manager.getTransaction();
		System.out.println("Running save method in ContactRepositoryImpl...");
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
	
		}catch (PersistenceException e) {
			e.printStackTrace();
			transaction.getRollbackOnly();
			
		}finally {
			manager.close();
		}
		return true;
	}

}
