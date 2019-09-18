package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.entity.InsurancePolicy;

public class LoadObjectTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session session=null;
		InsurancePolicy policy=null;
		
		//bootstrap hibernate
		cfg=new Configuration();
		
		//load cfg file
		cfg=cfg.configure("/com/app/cfgs/hibernate.cfg.xml");
		
		//Create Session factory
		factory=cfg.buildSessionFactory();
		
		//open Session
		session=factory.openSession();
		
		//load entity class obj
		 
		try {
		   policy=session.load(InsurancePolicy.class,new Integer(7));	
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			  if(policy!=null) {
				  System.out.println("Object Found:"+ policy);
			  }
			  else {
				  System.out.println("Object Not Found..");
			  }
			  
			//close session
			session.close();
			
			//close factory
			factory.close();
		}
	}//main

}//class
