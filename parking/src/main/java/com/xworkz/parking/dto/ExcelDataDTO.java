package com.xworkz.parking.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ExcelDataDTO implements Serializable, Comparable<ExcelDataDTO> {

	private String location;
	private String type;
	private String classification;
	private int terms;
	//private String terms;
	private double price;
	//private String price;
	private int discount;
	//private String discount;

	@Override
	public int compareTo(ExcelDataDTO o) {
		// TODO Auto-generated method stub
		return this.getLocation().compareTo(o.location);
	}

}
