package com.xworkz.signup.controller;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.signup.dto.ForgotDTO;
import com.xworkz.signup.service.ForgotService;

@Controller
public class ForgotController {
	
	private static Logger logger = Logger.getLogger(ForgotController.class);
	
	@Autowired
	private ForgotService forgotService;

	public ForgotController() {
		logger.info("inside getMessage()....of"+this.getClass().getSimpleName());
	}

	@RequestMapping("Forgot.do")
	public String onForgot(ForgotDTO forgotDTO,ModelMap map) {
		try {
		logger.info("inside getMessage()....Invoked onForgot method");
		logger.info("inside getMessage()....ForgotDTO");

		// String check = this.forgotService.validateForgot(forgotDTO);
		 boolean check1 = this.forgotService.validateForgotPassword(forgotDTO);
		 if (check1) {
				String signupEntity = this.forgotService.validateForgot(forgotDTO);
				if(Objects.nonNull(signupEntity));
				
			  ModelMap email = map.addAttribute("email", "Email is valid");
			  ModelMap password = map.addAttribute("password", "signupEntity");
			  
			  return "Forgot";
			  
			} else { 
				 String check = this.forgotService.validateForgot(forgotDTO);
				 {		 
				ModelMap failure = map.addAttribute("failuremessage","email is not valid");
				return "InvalidEmail";
				 
				}
			} 	
			 	
		} catch(NumberFormatException e) {
			logger.error("-->Exception occured",e);
		}

		return "Forgot";
	}
}



