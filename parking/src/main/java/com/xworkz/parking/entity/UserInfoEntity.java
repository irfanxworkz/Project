package com.xworkz.parking.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "userinfo")
@Entity
@NamedQuery(name = "findByUserEmail", query ="select userEmail from UserInfoEntity userEmail where userEmail.email=:mail")
@NamedQuery(name = "updateOTP", query = "update UserInfoEntity otp set otp.oneTimePassword=:onetime where otp.email=:mail")
@NamedQuery(name = "findByOTP", query = "select findotp from UserInfoEntity findotp where findotp.oneTimePassword=:fotp")
public class UserInfoEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private long mobile;
	
	private String loginTime;
	
	//private static final long OTP_VALID_DURATION = 5 * 60 * 1000;
	
	private String oneTimePassword;
	
	private LocalDate otpRequstedTime;
	
	/*
	public boolean isOTPRequired() {
		if(this.getOneTimePassword() == null) {
			return false;
		}
		
		long currentTimeInMillis = System.currentTimeMillis();
		long otpRequestedTimeInMillis = this.otpRequstedTime.getTime();
		
		if(otpRequestedTimeInMillis + OTP_VALID_DURATION < currentTimeInMillis) {
			//OTP Expires
			return false;
		}
		return true;
	}
	*/
	
}
