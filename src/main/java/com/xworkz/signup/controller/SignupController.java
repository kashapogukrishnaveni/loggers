package com.xworkz.signup.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.xworkz.signup.dto.SignupDTO;
import com.xworkz.signup.service.SignupService;

@Controller
@RequestMapping("/")
public class SignupController {
	
	private static Logger logger = Logger.getLogger(SignupController.class);
	
	@Autowired
	private SignupService signupService;
	
	//PropertyPlaceholderConfigurer
	
	public SignupController() {
		logger.info("inside getMessage()....of"+this.getClass().getSimpleName());
	}
	@RequestMapping("Signup.do")
	public String onSignup(SignupDTO signupDTO,ModelMap map) {
		
		try {
			logger.info("inside getMessage()...Invoked onSignup method");
			boolean check = this.signupService.validateAndSave(signupDTO);
			if (check) {
				map.addAttribute("name",signupDTO.getUsername());
				map.addAttribute("Signup", "Data saved");
			} else {
				map.addAttribute("Signup", "Data not saved");
			}
			
			
		} catch(NumberFormatException e) {
			logger.error("-->Exception occured",e);
		}

		return "Signup";
	}
}
