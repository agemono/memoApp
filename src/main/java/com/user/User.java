package com.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "User")

public class User {

	@Id
	@Getter
	@Setter
	@Column(length = 50, nullable = false)
	private String user_id;

	@Getter
	@Setter
	@Column(length = 200, nullable = false)
	private String password;

	@Getter
	@Setter
	@Column(length = 20, nullable = false)
	private String role;

}
