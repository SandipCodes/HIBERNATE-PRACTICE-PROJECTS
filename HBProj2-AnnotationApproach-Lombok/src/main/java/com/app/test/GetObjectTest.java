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
		
		//bootstap hibernate
		cfg=new Configuration();
		
		//load cfg file and create in_mem_meta_data
		cfg=cfg.configure("/com/app/cfg/hibernate.cfg.xml");
		
		//build sessionFactory
		//it will build factory object by dumping all the inmem data referred by cfg to factory object
		factory=cfg.buildSessionFactory();
		
		//open session
		session=factory.openSession();
		
		//get an object from db
         p=session.get(Person.class, 1); 
         System.out.println("Received Data is:" + p);
         
         p=session.get(Person.class, 2); 
         System.out.println("Received Data is:" + p);
         
         //close session obj
         session.close();
         //close factory obj
         factory.close();
	}

}
