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

	public ParkingServicesImpl() {
		log.info("Creating no-arg Constructor Using ParkingServicesImpl!!!");
	}

	@Override
	public ParkingDTO loginAdmin(String email, String password) {
		log.info("Running login method in ParkingServicesImpl... ");
		ParkingEntity entiy = this.repo.loginAdmin(email);
		if (entiy != null) {
			if (entiy.getEmail().equals(email) && entiy.getPassword().equals(password)) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy hh:mm:ss");
				entiy.setLoginTime(LocalDateTime.now().format(formatter));
				ParkingDTO dto = new ParkingDTO();
				BeanUtils.copyProperties(entiy, dto);
				return dto;
			} else {
				log.info("not a valid credential");
				return null;
			}
		} else {
			log.info("no data found");
			return null;
		}
	}

	@Override
	public boolean adminSaveAndValidate(ParkingInfoDTO parkingInfoDTO) {
		ParkingInfoEntity parkingInfoEntity = new ParkingInfoEntity();

		BeanUtils.copyProperties(parkingInfoDTO, parkingInfoEntity);
		log.info("Info Entity:" + parkingInfoEntity);
		return this.repo.saveAdmin(parkingInfoEntity);
	}

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

	@Override
	public boolean userSaveAndValidate(UserInfoDTO userInfoDTO, UserParkingInfoDTO userParkingInfoDTO) {
		log.info("running userSaveAndValidate() in ParkingSrervicesImpl...");
		System.out.print(userInfoDTO);	
		System.out.print(userParkingInfoDTO);	
		UserInfoEntity record = this.repo.findByUserEmail(userInfoDTO.getEmail());
		System.out.println(record);
		if(record == null) {
			UserInfoEntity userInfoEntity = new UserInfoEntity();
			BeanUtils.copyProperties(userInfoDTO, userInfoEntity);
			boolean saveUserInfo = repo.saveUserInfo(userInfoEntity);
			System.out.println("parking user info" + saveUserInfo);
			log.info("UserInfoEntity: " + saveUserInfo);
			
			UserParkingInfoEntity userParkingInfoEntity = new UserParkingInfoEntity();
			UserInfoEntity userByEmail =repo.findByUserEmail(userInfoDTO.getEmail());
			userParkingInfoDTO.setUserId(userByEmail.getId());
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

	@Override
	public boolean findByUserEmail(String email) {
		log.info("running findByUserEmail() in ParkingServicesImpl...");
		UserInfoEntity userInfoEntity = repo.findByUserEmail(email);
		if (userInfoEntity != null) {
			return true;
		}
		return false;
	}

	@Override
	public UserInfoDTO sendOTP(String email, UserInfoEntity userInfoEntity) {
		log.info("Running UserSign() Method in parkingServicesImpl...");
		userParkingEmail.otpSendMail(email, userInfoEntity);
		String otp = userInfoEntity.getOneTimePassword();
		System.out.println("OTP=============================="+otp);
		if(userInfoEntity.getEmail().equals(email)){
			this.repo.sendOtp(otp, email);
		UserInfoDTO dto=new UserInfoDTO();
		BeanUtils.copyProperties(userInfoEntity, dto);
		return dto;

		} else {
			log.info("email id is not exist");
			return null;
		}
	}
	
	@Override
	public UserInfoDTO loginUser(String email,String oneTimePassword) {
		log.info("Running loginUser() method in ParkingServicesImpl... ");
		UserInfoEntity userInfoEntity = this.repo.loginUser(email);
		if (userInfoEntity != null) {
			if (userInfoEntity.getEmail().equals(email) && userInfoEntity.getOneTimePassword().equals(oneTimePassword)) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy hh:mm:ss");
				userInfoEntity.setLoginTime(LocalDateTime.now().format(formatter));
				UserInfoDTO userInfoDTO = new UserInfoDTO();
				BeanUtils.copyProperties(userInfoEntity, userInfoDTO);
				return userInfoDTO;
			} else {
				log.info("not a valid credential");
				return null;
			}
		} else {
			log.info("no data found");
			return null;
		}
	}
	
	@Override
	public UserParkingInfoDTO findByUserId(String email,int userId) {
		
		UserInfoEntity userInfoEntity =this.repo.loginUser(email);
		System.err.println("==================================");
		System.out.println("userInfoEntity is : "+userInfoEntity);
		System.err.println("==================================");
		
		UserParkingInfoEntity  userParkingInfoEntity = this.repo.findByUserId(userId);
		System.err.println("==================================");
		System.out.println("userParkingInfoEntity is : "+userParkingInfoEntity);
		System.err.println("==================================");
		
			if(userInfoEntity.getId() == userParkingInfoEntity.getUserId() ) {
			UserParkingInfoDTO userParkingInfoDTO=new UserParkingInfoDTO();
			BeanUtils.copyProperties(userParkingInfoEntity, userParkingInfoDTO);
			System.out.println("userParkingInfoDTO is : "+userParkingInfoDTO);
			return userParkingInfoDTO;
			}
			else {
				log.info("data not matching");
				return null;
			}
	}
}