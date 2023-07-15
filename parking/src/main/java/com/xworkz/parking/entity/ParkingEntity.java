package com.xworkz.parking.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Table(name = "admin")
@Entity
@NamedQuery(name = "findByEmail", query = "select remo from ParkingEntity remo where remo.email=:fn")
@NamedQuery(name = "loginDateAndTime", query = "update from ParkingEntity time set time.loginTime=:tm")
public class ParkingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private String createdBy;
	private String updatedBy;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	@Column(name = "loginTime")
	private String loginTime;
	

	
}
