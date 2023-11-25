package com.xworkz.parking.services;

import java.util.List;

import com.xworkz.parking.dto.ParkingDTO;
import com.xworkz.parking.dto.ParkingInfoDTO;
import com.xworkz.parking.dto.UserInfoDTO;
import com.xworkz.parking.dto.UserParkingInfoDTO;
import com.xworkz.parking.entity.UserInfoEntity;
import com.xworkz.parking.entity.UserParkingInfoEntity;

public interface ParkingServices {
	
	default ParkingDTO loginAdmin(String email,String password) {
		return null;	
	}
	
	boolean adminSaveAndValidate(ParkingInfoDTO parkingInfoDTO);

	default List<ParkingInfoDTO> findByLocationAdmin(String location){
		return null;
	}
	
	default boolean userRegistration(UserInfoDTO userInfoDTO) {
		return false;
		
	}
	
	boolean saveUserParkingInfo(String email, UserParkingInfoDTO userParkingInfoDTO);
	
	default ParkingInfoDTO findByLocationTypeClassificationTerm(String location, String type, String classification, String term) {
		return null;
	}
	
	default boolean findByUserEmail(String email) {
		return false;
	}
	
	default List<UserInfoDTO> viewUserData(String email) {
		return null;
	}
	
	default UserInfoDTO sendOTP(String email) {
		return null;
	}
	
	default UserInfoDTO loginUser(String email,String oneTimePassword) {
		return null;	
	}
	
	  default List<UserParkingInfoDTO> findByUserId(int i) { 
		return null;
		
	  }

	default boolean userupdate(UserInfoDTO userInfoDTO, UserParkingInfoDTO userParkingInfoDTO) {
		return false;
	}

	


	  

}