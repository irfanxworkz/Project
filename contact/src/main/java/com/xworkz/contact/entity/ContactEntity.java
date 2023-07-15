package com.xworkz.contact.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Table(name = "contact_table")
@Entity
public class ContactEntity {
	
	public ContactEntity() {
		log.info("Creating no-arg constructor using ContactEntity!!!");
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "t_id")
	private int id;
	@Column(name = "t_name")
	private String name;
	@Column(name = "t_email")
	private String email;
	@Column(name = "t_mobile")
	private String mobile;
	@Column(name = "t_comments")
	private String comments;
	@Column(name = "t_fileName")
	private String fileName;
	@Column(name = "t_contentType")
	private String contentType;
	@Column(name = "t_fileSize")
	private long fileSize;
}
