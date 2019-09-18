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
		
		//add mapping file
		cfg.addFile("src/main/java/com/app/cfgs/InsurancePolicy.hbm.xml");
		
		//build session factory
		factory=cfg.buildSessionFactory();
		
		//open Session
		session=factory.openSession();
		
		try {
			
		//unable to execute this code for Oracle..See later
		policy=session.get(InsurancePolicy.class, 7);
		
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
