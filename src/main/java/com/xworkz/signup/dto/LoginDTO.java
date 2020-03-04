package com.xworkz.signup.dto;

import org.apache.log4j.Logger;

public class LoginDTO {

	private static Logger logger = Logger.getLogger(LoginDTO.class);
	
	private String email;
	private String password;
	
	public LoginDTO() {
		logger.info("inside getMessage()....of"+this.getClass().getSimpleName());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", password=" + password + "]";
	}
	
}
