package com.xworkz.parking.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class UserInfoDTO implements Serializable,Comparable<UserInfoDTO>{
	
	private int id;
	private String name;
	private String email;
	private long mobile;
	
	private String oneTimePassword;
	
	private LocalDate otpRequstedTime;
	
	private String loginTime;

	@Override
	public int compareTo(UserInfoDTO o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}
	

}
