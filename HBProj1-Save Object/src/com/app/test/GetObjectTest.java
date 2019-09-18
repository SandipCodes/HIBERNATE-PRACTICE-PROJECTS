package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.model.Person;

public class GetObjectTest {

	public static void main(String[] args) {
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session session=null;
		Person p=null;
		
		//bootstrap Hibernate
		cfg=new Configuration();
		
		//locate and load both the .xml file
		cfg=cfg.configure("/com/app/cfg/hibernate.cfg.xml");
		
		//build sessionFactory
		factory=cfg.buildSessionFactory();
		
		//open session
		session=factory.openSession();
		
		//get object 
		 p=session.get(Person.class, 101);
		 
		 System.out.println("Selected Data is::"+ p);
		
	}//main

}//class
