package com.xworkz.parking.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserParkingInfoDTO implements Serializable,Comparable<UserParkingInfoDTO>{
	
	private int id;
	private int userId;
	private String location;
	private String type;
	private String classification;
	private String terms;
	private double price;
	private String discount;
	private double totalAmount;
	
	private String loginTime;

	@Override
	public int compareTo(UserParkingInfoDTO o) {

		return this.getLocation().compareTo(o.getLocation());
	}
	
	

}
