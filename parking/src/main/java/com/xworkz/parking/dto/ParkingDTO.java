package com.xworkz.parking.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class ParkingDTO implements Serializable, Comparable<ParkingDTO>{
	
	private int id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String createdBy;
	
	private String updatedBy;
	
	private LocalDateTime createdDate;

	private LocalDateTime updatedDate;
	
	private String loginTime;

	@Override
	public int compareTo(ParkingDTO o) {
		log.info("Running CompareTo method in parkingDTO...");
		return this.getName().compareTo(o.getName());
	}
}
