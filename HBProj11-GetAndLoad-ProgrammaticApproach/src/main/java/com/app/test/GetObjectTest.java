package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.entity.InsurancePolicy;

public class GetObjectTest {

	public static void main(String[] args) {
	
		Configuration cfg=null;
		SessionFactory factory=null;
		Session session=null;
		InsurancePolicy policy=null;
		
		Transaction tx=null;
		boolean flag=false;
		
		//bootstrap hibernate
		cfg=new Configuration();
		
		//load cfgs and prepare inmem meta data
		cfg=cfg.configure("/com/app/cfgs/hibernate.cfg.xml");
		
		
		//set properties through program
		
		cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test2");
		cfg.setProperty("hibernate.connection.username", "root");
		cfg.setProperty("hibernate.connection.password", "root");
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		cfg.setProperty("connection.pool_size", "14");
		cfg.setProperty("sql_show", "true");
		cfg.setProperty("format_sql", "true");
		cfg.setProperty("cache.provider_class", "org.hibernate.cache.NoCacheProvider");


		System.out.println("Pool size :" +cfg.getProperty("connection.pool_size"));
		//specify mapping file
		cfg.addFile("src/main/java/com/app/cfgs/InsurancePolicy.hbm.xml");
		//build session factory
		factory=cfg.buildSessionFactory();
		
		//open Session
		session=factory.openSession();
		
		try {
			
		//unable to execute this code for Oracle..See later
		policy=session.get(InsurancePolicy.class, 3);
		
		if(policy !=null) {
			System.out.println("Found Object: "+policy);	
		}
		else {
			System.out.println("Object not Present in DB.");
		}
	}
	catch(HibernateException he) {
		he.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
    finally {
    	
    	//close session
    	session.close();
    	//close factory
    	factory.close();
    	
	}
	
	
 }//main

}//class
