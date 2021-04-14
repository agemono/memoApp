package com.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "loginData")

public class User {

	@Id
	@Getter
	@Setter
	@Column(length = 50, nullable = false)
	private String userid;

	@Getter
	@Setter
	@Column(length = 50, nullable = false)
	private String password;



}
