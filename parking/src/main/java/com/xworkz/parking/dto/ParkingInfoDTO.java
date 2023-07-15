package com.xworkz.parking.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ParkingInfoDTO implements Serializable, Comparable<ParkingInfoDTO>{
	
	private int id;
	
	private String location;
	
	private String type;
	
	private String classification;
	
	private String terms;
	
	private double price;
	
	private String discount;
	
	@Override
	public int compareTo(ParkingInfoDTO o) {
		return this.getLocation().compareTo(o.getLocation());
	}

	
}
