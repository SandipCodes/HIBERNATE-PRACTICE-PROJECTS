package com.app.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.entity.InsurancePolicy;

public class LoadObjectTest {

	public static void main(String[] args) {
		InputStream is=null;
		Properties properties=null;
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session session=null;
		InsurancePolicy policy=null;
		
		try {
			is=new FileInputStream("src/main/java/com/app/commons/app.properties");
			properties=new Properties();
			properties.load(is);
		}
		catch(FileNotFoundException fnf) {
			fnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//bootstrap hibernate
		cfg=new Configuration();
		
		//specify properties file
		cfg.setProperties(properties);
		
		//specify mapping file
		cfg.addFile("src/main/java/com/app/cfgs/InsurancePolicy.hbm.xml");
		
		//Create Session factory
		factory=cfg.buildSessionFactory();
		
		//open Session
		session=factory.openSession();
		
		//load entity class obj
		 
		try {
		   policy=session.load(InsurancePolicy.class,3);	
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
