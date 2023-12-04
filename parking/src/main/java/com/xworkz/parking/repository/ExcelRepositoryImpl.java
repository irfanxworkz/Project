package com.xworkz.parking.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.parking.entity.ParkingInfoEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ExcelRepositoryImpl implements ExcelRepository {
	
			@Autowired
			private EntityManagerFactory entityManagerFactory;
	
			@Override
			public boolean saveParkinghrowExcel(List<ParkingInfoEntity> entities) {
				log.info("Running saveParkinghrowExcel() method in ExcelRepositoryImpl...");
				EntityManager manager = entityManagerFactory.createEntityManager();
		try {
		        EntityTransaction transaction = manager.getTransaction();
		        transaction.begin();
		        for (ParkingInfoEntity entity : entities) {
		        	manager.persist(entity);
		            }
		            transaction.commit();
		            return true;
		    } catch (PersistenceException e) {
		            e.printStackTrace();
		            return false;
		    } finally {
		            if (manager != null && manager.isOpen()) {
		                manager.close();
		            }
		    }
	   }
   }
