package com.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "loginData")

public class loginData {

	@Id



	@Getter
	@Setter
	@Column(length = 50, nullable = false)
	private String userid;

	@Getter
	@Setter
	@Column(length = 50, nullable = false)
	private String userpassword;

	/*public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;

	}*/
}
