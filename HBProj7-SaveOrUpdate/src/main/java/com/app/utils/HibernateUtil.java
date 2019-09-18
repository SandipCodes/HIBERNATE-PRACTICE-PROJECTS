package com.app.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	 private static SessionFactory factory;
	 
	 static {
		 
		    Configuration cfg=null;
		    
		    //bootstrap hibernate
		    cfg=new Configuration();
		    //load cfg and prepare In mem meta data
		    cfg=cfg.configure("/com/app/cfgs/hibernate.cfg.xml");
		    
		    //build session factory
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
		 
		 if(ses !=null)
			 ses.close();
	 }//closeSessio()
	 
	 public static void closeSessionFactory() {
		 
		 if(factory !=null)
			 factory.close();
	 }//closeSessionFactory()
	 
}//class
