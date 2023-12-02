package com.xworkz.parking.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "parkingexcel")
@Entity
public class ExcelEntity implements Serializable, Comparable<ExcelEntity>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String location;
	private String type;
	private String classification;
	private int terms;
	private double price;
	private int discount;
	
	@Override
	public int compareTo(ExcelEntity o) {
		// TODO Auto-generated method stub
		return this.getLocation().compareTo(o.location);
	}
	
	

}
