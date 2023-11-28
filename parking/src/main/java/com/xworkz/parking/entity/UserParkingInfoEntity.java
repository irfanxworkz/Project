package com.xworkz.parking.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "userparkinginfo")
@NamedQueries({
    @NamedQuery(name = "findByUserId", query = "SELECT entity FROM UserParkingInfoEntity entity WHERE entity.userId = :uid"),
    @NamedQuery(name = "findByid", query = "SELECT parkingid FROM UserParkingInfoEntity parkingid WHERE parkingid.id = :pid"),
    @NamedQuery(name = "updateUserParkingInfo", query = "UPDATE UserParkingInfoEntity " +
            "SET location = :newLocation, type = :newType, classification = :newClassification, " +
            "terms = :newTerms, price = :newPrice, discount = :newDiscount, totalAmount = :newTotalAmount " +
            "WHERE id = :id")
})
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

	//@NamedQuery(name = "updateOTP", query = "update UserInfoEntity otp set otp.oneTimePassword=:onetime where otp.email=:mail")
	
}
