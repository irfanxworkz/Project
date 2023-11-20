package com.xworkz.parking.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "userparkinginfo")
@NamedQuery(name = "findByUserId",query = "select id from UserParkingInfoEntity id where id.userId=:uid")
public class UserParkingInfoEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int userId;
	private String location;
	private String type;
	private String classification;
	private String terms;
	private double price;
	private String discount;
	private double totalAmount;

}
