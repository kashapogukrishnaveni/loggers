package com.xworkz.signup.dto;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
@Component
public class SignupDTO {
	
	private static Logger logger = Logger.getLogger(SignupDTO.class);
	
	private String username;
	private String email;
	private String password;
	
	public SignupDTO() {
		logger.info("inside getMessage()....of"+this.getClass().getSimpleName());
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		return "SignupDTO [username=" + username + ", email=" + email + ", password=" + password + "]";
	}
	
}
