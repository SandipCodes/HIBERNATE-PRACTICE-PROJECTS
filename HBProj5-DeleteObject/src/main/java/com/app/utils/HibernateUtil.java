package com.app.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory factory;
	
	static {
		
		  Configuration cfg=null;
		  
		  //bootstrap the Hibernate
		  cfg=new Configuration();
		  
		  //load cfg file
		  cfg=cfg.configure("/com/app/cfgs/hibernate.cfg.xml");
		  
		  //Build factpry
		  factory=cfg.buildSessionFactory();
	}
	
	public static Session getSession() {

		 if(factory !=null)
			  return factory.openSession();
		 else
			 return null;
	}
	public static void closeSession(Session session) {
		if(session !=null) 
		     session.close();
	}
	
	public static void closeSessionFactory() {
		if(factory !=null)
			 factory.close();
	}
	
	
}//class
