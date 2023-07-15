package com.xworkz.parking.services;

import java.util.List;

import com.xworkz.parking.dto.ParkingDTO;
import com.xworkz.parking.dto.ParkingInfoDTO;
import com.xworkz.parking.dto.UserInfoDTO;
import com.xworkz.parking.dto.UserParkingInfoDTO;
import com.xworkz.parking.entity.UserInfoEntity;

public interface ParkingServices {
	
	default ParkingDTO loginAdmin(String email,String password) {
		return null;	
	}
	
	boolean adminSaveAndValidate(ParkingInfoDTO parkingInfoDTO);

	default List<ParkingInfoDTO> findByLocationAdmin(String location){
		return null;
	}
	
	boolean userSaveAndValidate(UserInfoDTO userInfoDTO, UserParkingInfoDTO userParkingInfoDTO);
	
	default ParkingInfoDTO findByLocationTypeClassificationTerm(String location, String type, String classification, String term) {
		return null;
	}
	
	default boolean findByUserEmail(String email) {
		return false;
	}
	
	boolean sendOTP(String email, UserInfoEntity userInfoEntity);
	
	default UserInfoDTO loginUser(String email,String oneTimePassword) {
		return null;	
	}
}
