package com.xworkz.parking.services;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.parking.dto.ParkingDTO;
import com.xworkz.parking.dto.ParkingInfoDTO;
import com.xworkz.parking.dto.UserInfoDTO;
import com.xworkz.parking.dto.UserParkingInfoDTO;
import com.xworkz.parking.entity.ParkingEntity;
import com.xworkz.parking.entity.ParkingInfoEntity;
import com.xworkz.parking.entity.UserInfoEntity;
import com.xworkz.parking.entity.UserParkingInfoEntity;
import com.xworkz.parking.repository.ParkingRepository;
import com.xworkz.parking.util.UserParkingEmail;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ParkingServicesImpl implements ParkingServices {

	@Autowired
	private ParkingRepository repo;
	
	@Autowired
	private UserParkingEmail userParkingEmail;

	/* this method for Admin login */
	@Override
	public ParkingDTO loginAdmin(String email, String password) {
		/* log.info("Running loginAdmin method in ParkingServicesImpl... "); */
		ParkingEntity entiy = this.repo.loginAdmin(email);
		if (entiy != null) {
			if (entiy.getEmail().equals(email) && entiy.getPassword().equals(password)) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy hh:mm:ss");
				entiy.setLoginTime(LocalDateTime.now().format(formatter));
				ParkingDTO dto = new ParkingDTO();
				BeanUtils.copyProperties(entiy, dto);
				return dto;
			} else {
				/* log.info("not a valid credential"); */
				return null;
			}
		} else {
			/* log.info("no data found"); */
			return null;
		}
	}
	
	/* this method for add parking info throw admin */
	@Override
	public boolean adminSaveAndValidate(ParkingInfoDTO parkingInfoDTO) {
		ParkingInfoEntity parkingInfoEntity = new ParkingInfoEntity();
		BeanUtils.copyProperties(parkingInfoDTO, parkingInfoEntity);
		log.info("Info Entity:" + parkingInfoEntity);
		return this.repo.saveAdmin(parkingInfoEntity);
	}

	/* this method for find all parking info by location */
	@Override
	public List<ParkingInfoDTO> findByLocationAdmin(String location) {
		List<ParkingInfoEntity> entities = this.repo.findByLocationAdmin(location);
		List<ParkingInfoDTO> dtos = entities.stream().map(ent -> {
			ParkingInfoDTO dto = new ParkingInfoDTO();
			BeanUtils.copyProperties(ent, dto);
			return dto;
		}).collect(Collectors.toList());
		return dtos;
	}
	
	/* this method for UserAjexController */
	@Override
	public ParkingInfoDTO findByLocationTypeClassificationTerm(String location, String type, String classification,
			String term) {
		log.info("running findByLocationTypeClassificationTerm() method in ParkingServicesImpl...");
		ParkingInfoEntity parkingInfoEntity = repo.findByLocationTypeClassificationTerm(location, type, classification,
				term);
		if (parkingInfoEntity != null) {
			log.info("data is already exist");
			ParkingInfoDTO parkingInfoDTO = new ParkingInfoDTO();
			BeanUtils.copyProperties(parkingInfoEntity, parkingInfoDTO);
			return parkingInfoDTO;
		}
		return null;
	}
	
	/* this method for User Registration */
	@Override
	public boolean userRegistration(UserInfoDTO userInfoDTO) {
		/* log.info("running userRegistration() in ParkingSrervicesImpl..."); */
		UserInfoEntity record = this.repo.findByUserEmail(userInfoDTO.getEmail());
		if(record == null) {
			UserInfoEntity userInfoEntity = new UserInfoEntity();
			BeanUtils.copyProperties(userInfoDTO, userInfoEntity);
			boolean saveUserInfo = repo.saveUserInfo(userInfoEntity);
			/* log.info("UserInfoEntity: " + saveUserInfo); */
			return true;
		}
		else {
			/* log.info("record is not null"); */
			return false;
		}
		
	}
	
	/* this method for UserAjexController */
	@Override
	public boolean findByUserEmail(String email) {
		/* log.info("running findByUserEmail() in ParkingServicesImpl..."); */
		UserInfoEntity userInfoEntity = repo.findByUserEmail(email);
		if (userInfoEntity != null) {
			return true;
		}
		return false;
	}

	/* this method for finding email in userInfo */
	@Override
	public List<UserInfoDTO> viewUserData(String email) {
		/* log.info("running viewUserData() in ParkingServicesImpl..."); */
		List<UserInfoEntity> userInfoEntity = repo.userAllDetails(email);
		if (userInfoEntity != null) {
		List<UserInfoDTO> userInfoDTO = userInfoEntity.stream().map(uent -> {
			UserInfoDTO userInfoDTO1=new UserInfoDTO();
			BeanUtils.copyProperties(uent, userInfoDTO1);
			return userInfoDTO1;
		}).collect(Collectors.toList());
		return userInfoDTO;
	}
		return null;
	}
	
	/* this method for send otp User email */
	@Override
	public UserInfoDTO sendOTP(String email) {
		/* log.info("Running sendOTP() Method in parkingServicesImpl..."); */
		UserInfoEntity userInfoEntity = repo.findByUserEmail(email);
		if(userInfoEntity != null) {
				boolean status=userParkingEmail.otpSendMail(email, userInfoEntity);
				boolean status1=this.repo.sendOtp(userInfoEntity.getOneTimePassword(), email);
				System.err.println("OTP=============================="+userInfoEntity.getOneTimePassword());
			UserInfoDTO dto=new UserInfoDTO();
			BeanUtils.copyProperties(userInfoEntity, dto);
			return dto;
			} else {
				/* log.info("email id is not exist"); */
			}
			return null;
	}
	
	/* this method for user login */
	@Override
	public UserInfoDTO loginUser(String email,String oneTimePassword) {
		/* log.info("Running loginUser() method in ParkingServicesImpl... "); */
		UserInfoEntity userInfoEntity = this.repo.findByUserEmail(email);
		if (userInfoEntity != null) {
			if (userInfoEntity.getEmail().equals(email) && userInfoEntity.getOneTimePassword().equals(oneTimePassword)) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy hh:mm:ss");
				userInfoEntity.setLoginTime(LocalDateTime.now().format(formatter));
				UserInfoDTO userInfoDTO = new UserInfoDTO();
				BeanUtils.copyProperties(userInfoEntity, userInfoDTO);
				return userInfoDTO;
			} else {
				/* log.info("not a valid credential"); */
				return null;
			}
		} else {
			/* log.info("no data found"); */
			return null;
		}
	}
	
	/* this method for add User Parking info */
	@Override
	public boolean saveUserParkingInfo(String email, UserParkingInfoDTO userParkingInfoDTO) {
		/* log.info("running userSaveAndValidate() in ParkingSrervicesImpl..."); */
		UserInfoEntity userByEmail = this.repo.findByUserEmail(email);
		if(userByEmail != null) {
			UserParkingInfoEntity userParkingInfoEntity = new UserParkingInfoEntity();
			/* UserInfoEntity userByEmail =repo.findByUserEmail(userInfoDTO.getEmail()); */
			userParkingInfoDTO.setUserId(userByEmail.getId());
			BeanUtils.copyProperties(userParkingInfoDTO, userParkingInfoEntity);
			boolean saveUserParkingInfo = repo.saveUserParkingInfo(userParkingInfoEntity);
			/* log.info("UserParkingInfoEntity: " + saveUserParkingInfo); */
			return true;
		}
		else {
			/* log.info("record is not null"); */
			return false;
		}
	}
	
	/* this method for finding UserId in UserParkingInfo */
	@Override
	public List<UserParkingInfoDTO> findByUserId(int userId) {
		List<UserParkingInfoEntity>  userParkingInfoEntities = this.repo.findByUserId(userId);
		List<UserParkingInfoDTO> userParkingInfoDTOs = userParkingInfoEntities.stream().map(ent ->{
			UserParkingInfoDTO dto = new UserParkingInfoDTO();
			BeanUtils.copyProperties(ent, dto);
			return dto;
		}).collect(Collectors.toList());
		System.err.println("userParkingInfoDTO is : "+userParkingInfoDTOs);
		return userParkingInfoDTOs;	
	}
	
	/* this method for update user parking details */
	@Override
	public boolean userupdate(UserInfoDTO userInfoDTO, UserParkingInfoDTO userParkingInfoDTO) {
		log.info("running userupdate() in ParkingSrervicesImpl...");
		UserInfoEntity record = this.repo.findByUserEmail(userInfoDTO.getEmail());
		if(record != null) {
			UserInfoEntity userInfoEntity = new UserInfoEntity();
			BeanUtils.copyProperties(userInfoDTO, userInfoEntity);
			boolean saveUserInfo = repo.saveUserInfo(userInfoEntity);
			log.info("UserInfoEntity: " + saveUserInfo);
			
			UserParkingInfoEntity userParkingInfoEntity = new UserParkingInfoEntity();
			UserInfoEntity userByEmail =repo.findByUserEmail(userInfoDTO.getEmail());
			System.out.println("=============================================================================");
			BeanUtils.copyProperties(userParkingInfoDTO, userParkingInfoEntity);
			boolean saveUserParkingInfo = repo.saveUserParkingInfo(userParkingInfoEntity);
			log.info("UserParkingInfoEntity: " + saveUserParkingInfo);
			
			return true;
		}
		else {
			log.info("record is not null");
			return false;
		}
		
	}
}