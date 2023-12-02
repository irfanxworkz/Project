package com.xworkz.parking.repository;

import java.util.List;
import com.xworkz.parking.entity.ParkingEntity;
import com.xworkz.parking.entity.ParkingInfoEntity;
import com.xworkz.parking.entity.UserInfoEntity;
import com.xworkz.parking.entity.UserParkingInfoEntity;

public interface ParkingRepository{
	
	default ParkingEntity loginAdmin(String email) {
		return null;
	}
	
	boolean saveAdmin(ParkingInfoEntity parkingInfoEntity);
	
	default List<ParkingInfoEntity> findByLocationAdmin(String location){
		return null;
	}
	
	boolean saveUserInfo(UserInfoEntity userInfoEntity);
	
	boolean saveUserParkingInfo(UserParkingInfoEntity userParkingInfoEntity);
	
	default ParkingInfoEntity findByLocationTypeClassificationTerm(String location, String type, String classification, String term) {
		return null;
	}
	
	default UserInfoEntity findByUserEmail(String email) {
		return null;
	}
	
	boolean sendOtp(String oneTimePassword, String email);

	default List<UserParkingInfoEntity> findByUserId(int userId) {
		return null;
	}

	default UserInfoEntity userAllDetails(String email){
		return null;
	}

	default UserParkingInfoEntity findById(int id) {
		return null;
	}

	UserParkingInfoEntity updateUserParkingInfo(int id, String location, String type, String classification, String terms, double price,
			String discount, double totalAmount);

	//void updateProfilePicture(String email, byte[] newProfilePicture);

}