package com.xworkz.signup.dao;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.signup.entity.SignupEntity;

@Repository
public class LoginDAOImpl implements LoginDAO {
	
	private static Logger logger = Logger.getLogger(LoginDAOImpl.class);
	
	@Autowired
	private SessionFactory factory;
	
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	public LoginDAOImpl() {
		logger.info("inside getMessage()....of"+this.getClass().getSimpleName());
	}


	public SignupEntity fetchByEmailAndPassword(String email, String password) {

		Session session=null;
		
		try {
			session=factory.openSession();
			System.out.println("invoke program...");
			
			Query  query =session.getNamedQuery("fetchByEmailAndPassword");
			
			query.setParameter("email", email);
			query.setParameter("password", password);
			Object result=(query).uniqueResult();
			if(Objects.nonNull(result)) {
		
				//System.out.println("Entity found"+"\t"+email+"\t"+password);
				logger.info("inside getMessage()....Entity found");
				SignupEntity entity=(SignupEntity) result;
				return entity;
		}
		else
		{
			logger.info("inside getMessage()....Entity not found");
			return null;
		}
			
		} catch(NumberFormatException e) {
			logger.error("-->Exception occured",e);
		
		} finally {
			if(Objects.nonNull(session));
			logger.info("inside getMessage()....close session");
			session.close();
		}

	return null;
}

}


