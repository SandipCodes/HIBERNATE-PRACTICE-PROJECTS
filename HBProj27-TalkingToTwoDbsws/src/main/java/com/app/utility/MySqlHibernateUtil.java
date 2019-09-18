package com.app.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySqlHibernateUtil {


	private static SessionFactory factory;
	
	static {
		    Configuration cfg=null;
		    
		    //bootstrap hibernate
		    cfg=new Configuration();
		    
		    //load cfgs
		    cfg=cfg.configure("/com/app/cfgs/mysql_hibernate.cfg.xml");
		    
		    //bbuild session factory
		    factory=cfg.buildSessionFactory();
	}
	
	public static Session getSession() {
		Session ses=null;
		if(factory !=null) {
			ses=factory.openSession();
		}
		return ses;
	}
		
   public static void closeSession(Session ses) {
	    
	   if(ses !=null)
		   ses.close();
   }
   
   public static void closeFactory() {
	   
	   if(factory !=null)
		   factory.close();
   }

}
