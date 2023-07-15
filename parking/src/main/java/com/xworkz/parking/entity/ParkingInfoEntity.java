package com.xworkz.parking.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "parkinginfo")
@Entity
@NamedQuery(name = "findByLocation",query = "select info from ParkingInfoEntity as info where info.location like :lcn")
@NamedQuery(name = "findByLTCT" ,query = "select ltct from ParkingInfoEntity ltct where ltct.location=:lc and ltct.type=:typ and ltct.classification=:cls and ltct.terms=:trm ")
public class ParkingInfoEntity implements Serializable, Comparable<ParkingInfoEntity>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String location;
	private String type;
	private String classification;
	private String terms;
	private double price;
	private String discount;

	@Override
	public int compareTo(ParkingInfoEntity o) {
		// TODO Auto-generated method stub
		return this.getLocation().compareTo(o.location);
	}

}
