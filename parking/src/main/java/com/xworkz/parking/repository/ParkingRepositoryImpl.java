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

	/* this method for admin login */
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

	/* this method for save parking info throw admin*/
	@Override
	public boolean saveAdmin(ParkingInfoEntity parkingInfoEntity) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(parkingInfoEntity);
			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} 
		return true;
	}

	/* this method for view all parking info by location throw admin*/
	@Override
	public List<ParkingInfoEntity> findByLocationAdmin(String location) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery("findByLocation");
		query.setParameter("lcn", "%" + location + "%");
		List<ParkingInfoEntity> result = query.getResultList();
		/* log.info("result from repo " + result); */
		entityManager.close();
		return result;
	}
	
	/* this method for save userInfo for user registration */
	@Override
	public boolean saveUserInfo(UserInfoEntity userInfoEntity) {
		/* log.info("running saveUserInfo() method..."); */
		EntityManager manager = entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(userInfoEntity);
			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} 
		return true;
	}
	
	/* this method for find user email in userInfo */
	@Override
	public UserInfoEntity findByUserEmail(String email) {
		/* log.info("running findByUserEmail()..."); */
		EntityManager manager = entityManagerFactory.createEntityManager();
		Query query = manager.createNamedQuery("findByUserEmail");
		query.setParameter("mail", email);
		try {
			Object object = query.getSingleResult();
			return (UserInfoEntity) object;
		} catch (Exception e) {
			return null;
		}
	}

	/* this method for Send OTP on User Email */
	@Override
	public boolean sendOtp(String oneTimePassword, String email) {
		/* log.info("running userSignIn() method in parkingRepositoryImpl..."); */
		EntityManager manager = entityManagerFactory.createEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createNamedQuery("updateOTP");
		query.setParameter("mail", email);
		query.setParameter("onetime", oneTimePassword);
		int i = query.executeUpdate();
		manager.getTransaction().commit();
		manager.close();
		return true;
	}
	
	/* this method for  save userParkingInfo add parking details*/
	@Override
	public boolean saveUserParkingInfo(UserParkingInfoEntity userParkingInfoEntity) {
		/* log.info("running saveUserParkingInfo() method..."); */
		EntityManager manager = entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(userParkingInfoEntity);
			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return true;
	}

	/* this method for find 4 parking properties for userAjexController*/
	@Override
	public ParkingInfoEntity findByLocationTypeClassificationTerm(String location, String type, String classification, String term) {
		/*
		 * log.
		 * info("running findByLocationTypeClassificationTerm() method in ParkingRepository..."
		 * );
		 */
		EntityManager manager = entityManagerFactory.createEntityManager();
		Query query = manager.createNamedQuery("findByLTCT");
		query.setParameter("lc", location);
		query.setParameter("typ", type);
		query.setParameter("cls", classification);
		query.setParameter("trm", term);
		try {
			Object entity = query.getSingleResult();
			return (ParkingInfoEntity) entity;
		} catch (Exception e) {
			log.info("no record found");
			return null;
		}
	}
	
	/* this method for view all user details by email */
	@Override
	public List<UserInfoEntity> userAllDetails(String email) {
		/* log.info("running userAllDetails()..."); */
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery("findByUserEmail");
		query.setParameter("mail", email);
		List<UserInfoEntity> result = query.getResultList();
		/* log.info("result from repo " + result); */
		entityManager.close();
		return result;
	}

	/* this method for find userId in userParkingInfo  */
	@Override
	public List<UserParkingInfoEntity> findByUserId(int userId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery("findByUserId");
		query.setParameter("uid", userId);
		try {
			List<UserParkingInfoEntity> viParkingInfoEntities = query.getResultList();
			return  viParkingInfoEntities;
		} catch (Exception e) {
			return null;
		}
	}
}