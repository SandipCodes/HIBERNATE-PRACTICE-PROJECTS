package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.model.Person;

public class SaveObjectTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session session=null;
		Person p=null;
		Transaction tx=null;
		//bootstarp Hibernate
		cfg=new Configuration();
		
		//locate and load Hibernate cfg file
		//it will also load mapping related data & generate in memory meta data
		
		cfg=cfg.configure("/com/app/cfg/hibernate.cfg.xml");

		//build session factory which wil hold in-memory meta data currently repreented by cfg
		
		factory=cfg.buildSessionFactory();
		
		//open session
		
		 session=factory.openSession();
		 
		 //create entity object
		   p=new Person();
		//   p.setId(104);
		   p.setFirstName("SACHIN");
		   p.setLastName("PATIL");
		   p.setPhoneNumber(965874L);
		 
		 try {
			 tx=session.beginTransaction();
			 session.save(p);
			 tx.commit();
			 System.out.println("Object is saved successfulyy..");
		 }
		 catch(HibernateException he) {
			 tx.rollback();
			 he.printStackTrace();
		 }
		  
		
		 //close session
		 session.close();
		 //close factory
		 factory.close();
		
	}//main

}//class
