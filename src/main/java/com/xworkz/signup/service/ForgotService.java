package com.xworkz.signup.service;

import com.xworkz.signup.dto.ForgotDTO;

public interface ForgotService {

	public boolean validateForgotPassword(ForgotDTO forgotDTO);
	public String validateForgot(ForgotDTO forgotDTO);
	
}
