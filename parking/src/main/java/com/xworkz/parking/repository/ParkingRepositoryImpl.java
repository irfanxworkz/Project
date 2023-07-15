package com.xworkz.parking.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.parking.entity.ParkingEntity;
import com.xworkz.parking.entity.ParkingInfoEntity;
import com.xworkz.parking.entity.UserInfoEntity;
import com.xworkz.parking.entity.UserParkingInfoEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ParkingRepositoryImpl implements ParkingRepository {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public ParkingRepositoryImpl() {
		log.info("Creating no-arg Constructor using ParkingRepositoryIml!!!");
	}

	@Override
	public ParkingEntity loginAdmin(String email) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			Query query = entityManager.createNamedQuery("findByEmail");
			query.setParameter("fn", email);
			Object object = query.getSingleResult();
			log.info("repo: entity " + object);
			ParkingEntity entity = (ParkingEntity) object;
			return entity;
		} catch (PersistenceException e) {
			return null;
		}
	}

	@Override
	public boolean saveAdmin(ParkingInfoEntity parkingInfoEntity) {
		// EntityManager manager=null;
		// EntityTransaction transaction = null;
		EntityManager manager = entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			System.out.println("Running save method in ContactRepositoryImpl...");
			transaction.begin();
//			manager.merge(parkingInfoEntity);
			manager.persist(parkingInfoEntity);
			transaction.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();
			// transaction.getRollbackOnly();

		} finally {
			manager.close();
		}
		return true;
	}

	@Override
	public List<ParkingInfoEntity> findByLocationAdmin(String location) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery("findByLocation");
		query.setParameter("lcn", "%" + location + "%");
		List<ParkingInfoEntity> result = query.getResultList();
		log.info("result from repo " + result);
		entityManager.close();
		return result;
	}

	@Override
	public boolean saveUserInfo(UserInfoEntity userInfoEntity) {
		log.info("running saveUserInfo() method...");
		EntityManager manager = entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			System.out.println("Running save method in ContactRepositoryImpl...");
			transaction.begin();
			manager.persist(userInfoEntity);
			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return true;
	}
	
	@Override
	public boolean saveUserParkingInfo(UserParkingInfoEntity userParkingInfoEntity) {
		log.info("running saveUserParkingInfo() method...");
		EntityManager manager = entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			System.out.println("Running save method in ContactRepositoryImpl...");
			transaction.begin();
			manager.persist(userParkingInfoEntity);
			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return true;	}

	@Override
	public ParkingInfoEntity findByLocationTypeClassificationTerm(String location, String type, String classification,
			String term) {
		log.info("running findByLocationTypeClassificationTerm() method in ParkingRepository...");
		EntityManager manager = entityManagerFactory.createEntityManager();
		Query query = manager.createNamedQuery("findByLTCT");
		query.setParameter("lc", location);
		query.setParameter("typ", type);
		query.setParameter("cls", classification);
		query.setParameter("trm", term);
		try {
			Object entity = query.getSingleResult();
			return (ParkingInfoEntity)entity;
		} catch (Exception e) {
			log.info("no record found");
			return null;
		}
	}
	
	@Override
	public UserInfoEntity findByUserEmail(String email) {
		log.info("running findByUserEmail()...");
		EntityManager manager = entityManagerFactory.createEntityManager();
		Query query=manager.createNamedQuery("findByUserEmail");
		query.setParameter("mail", email);
		try {
			Object object=query.getSingleResult();
			return (UserInfoEntity)object;
		} catch (Exception e) {
			return null;
		}finally {
			manager.close();
		}
	}

	@Override
	public boolean sendOtp(String oneTimePassword, String email) {
		log.info("running userSignIn() method in parkingRepositoryImpl...");
		EntityManager manager = entityManagerFactory.createEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createNamedQuery("updateOTP");
		query.setParameter("email", email);
		query.setParameter("onetime", oneTimePassword);
		int i =query.executeUpdate();
		manager.getTransaction().commit();
		manager.close();
		return true;
	}
	
	@Override
	public UserInfoEntity loginUser(String email) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			Query query = entityManager.createNamedQuery("findByUserEmail");
			query.setParameter("mail", email);
			Object object = query.getSingleResult();
			log.info("repo: entity " + object);
			UserInfoEntity userInfoEntity = (UserInfoEntity) object;
			return userInfoEntity;
		} catch (PersistenceException e) {
			return null;
		}
	}
}	