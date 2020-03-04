package com.xworkz.signup.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.signup.dao.SignupDAO;
import com.xworkz.signup.dao.SignupDAOImpl;
import com.xworkz.signup.dto.SignupDTO;
import com.xworkz.signup.entity.SignupEntity;

@Service
public class SignupServiceImpl implements SignupService {
	
	private static Logger logger = Logger.getLogger(SignupDAOImpl.class);
	
	@Autowired
	private SignupDAO signupDAO;

	public SignupServiceImpl() {
		logger.info("inside getMessage()....of"+this.getClass().getSimpleName());
	}

	public boolean validateAndSave(SignupDTO signupDTO) {
		boolean valid = false;
		try {
			//System.out.println("save invoked " + signupDTO);
			logger.info("inside getMessage()....(\"save invoked \" + signupDTO");

			if (Objects.nonNull(signupDTO)) {
				//System.out.println("starting validation for " + signupDTO);
				logger.info("inside getMessage()....starting validation for \" + signupDTO");

				String username = signupDTO.getUsername();
				if (username != null && !username.isEmpty() && username.length() >= 5) {
					//System.out.println("Username is valid");
					logger.info("inside getMessage()...username is valid");
					valid = true;
				} else {
					//System.out.println("username is invalid");
					logger.info("inside getMessage()...username is invalid");
					if (username == null) {
						//System.out.println("username is null");
						logger.info("inside getMessage()...username is null");
					}
					if (username != null && username.length() < 5) {
						//System.out.println("name length is less than 5");
						logger.info("inside getMessage()...name length is less than 5");
					}
					valid = false;
				}

				String email = signupDTO.getEmail();
				if (valid && email != null && !email.isEmpty()) {
					//System.out.println("email is valid");
					logger.info("inside getMessage()...email is valid");
					valid = true;
				} else {
					if (valid) {
						//System.out.println("email is invalid");
						logger.info("inside getMessage()...email is invalid");
						valid = false;

					}
				}

				String password = signupDTO.getPassword();
				if (valid && password != null && !password.isEmpty() && password.length() >= 6) {
					//System.out.println("password is valid");
					logger.info("inside getMessage()...password is valid");
					valid = true;
				} else {
					if (valid) {
						//System.out.println("password is invalid");
						logger.info("inside getMessage()...password is invalid");
						valid = false;

					}
				}

			}

			// return valid;

			if (valid) {
				//System.out.println("Data is valid ,will convert  to entity");
				logger.info("inside getMessage()...\"Data is valid ,will convert  to entity");

				SignupEntity signupEntity = new SignupEntity();

				BeanUtils.copyProperties(signupDTO, signupEntity);

				SignupEntity fromdb = this.signupDAO.fetchByEmail(signupDTO.getEmail());
				if (fromdb == null) {
					//System.out.println("entity is ready \t " + signupEntity);
					logger.info("inside getMessage()...\"entity is ready \\t \" + signupEntity");
					//System.out.println("email does not exist in the db");
					logger.info("inside getMessage()...email does not exist in the db");
					signupDAO.save(signupEntity);
				} else {
					//System.out.println("email already exists, cannot save into db");
					logger.info("inside getMessage()...email already exists, cannot save into db");
					valid=false;
				}
			}

		}  catch(NumberFormatException e) {
			logger.error("-->Exception occured",e);
		}
		return false;
	}

}
