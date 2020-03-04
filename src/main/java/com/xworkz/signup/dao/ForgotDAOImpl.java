package com.xworkz.signup.dao;

import java.util.Objects;

import javax.transaction.Transaction;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.signup.entity.SignupEntity;

@Repository
public class ForgotDAOImpl implements ForgotDAO {
	
	private static Logger logger = Logger.getLogger(ForgotDAOImpl.class);
	
	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	public ForgotDAOImpl() {
		logger.info("inside getMessage()....of"+this.getClass().getSimpleName());
	}

	public String updatePasswordByEmail(String email,String password) {
		logger.info("inside getMessage()....Invoked updatepasswordbyemail method");
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			//session.getTransaction();
			//System.out.println("fetching");
			String hql = "SELECT se from SignupEntity se where email='" + email + "'";
			//System.out.println("email"+hql);
			logger.info("inside getMessage().... hql");
			//Query query = session.getNamedSQLQuery("updatePasswordByEmail");
			//query.setParameter("email", email);
			//query.setParameter("password", password);
			
			Query query = session.createQuery(hql);
			Object result = query.uniqueResult();
			
			if (Objects.nonNull(result)) {
				SignupEntity entity = (SignupEntity) result;
				Query query1 = session.createNamedQuery("update");
				query1.setParameter("email", email);
				password = "newPassword143";
				query1.setParameter("password", password);
				Object result1 = query1.executeUpdate();
				tx.commit();
				if(Objects.nonNull(result1)){
				return password;
				}
				//System.out.println("Entity found"+result);
			} else {
				//System.out.println("Entity not found");
				return null;
			}

		} catch(NumberFormatException e) {
			logger.error("-->Exception occured",e);
		}
		// return null;
		finally {
			session.close();

		}
		return null;
	}
}	

	