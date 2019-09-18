package com.app.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory factory=null;
	
	static {
		//bootsrap hibernate
		Configuration cfg=null;
		
		cfg=new Configuration();
		
		//load cfg and mapping files
		cfg=cfg.configure("/com/app/cfgs/hibernate.cfg.xml");
		
		//build SessionFactory
		factory=cfg.buildSessionFactory();
	}//static
	
	public static Session getSession() {
		
		Session ses=null;
		
		if(factory !=null) {
			ses=factory.openSession();
		}
		return ses;
	}//getSession()
	
	public static void closeSession(Session ses) {
	   
		 if(ses !=null) {
			 ses.close();
		 }
	}//closeSession()
	
	public static void closeSessionFactory() {
		
		if(factory !=null) {
			factory.close();
		}
	}//closeSessionFactory()
}//class
