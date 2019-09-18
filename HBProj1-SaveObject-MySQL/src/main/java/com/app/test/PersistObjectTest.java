package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.entity.Employee;

public class PersistObjectTest {

	public static void main(String[] args) {
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session session=null;
		Employee emp=null;
		Transaction tx=null;
		boolean flag=false;
		
		//bootStarp hibernate
		cfg=new Configuration();
		
		//load cfg file
		cfg=cfg.configure("/com/app/cfgs/hibernate.cfg.xml");
		
		//build Session factory
		factory=cfg.buildSessionFactory();
		
		//open Session
		session=factory.openSession();
		
		//create Entity object
		emp=new Employee();
		emp.setId(107);
		emp.setEname("SACHIN");
		emp.setEmail("ssh1@gmail.com");
		emp.setSalary(98764);
		try {
			tx=session.beginTransaction();
			session.persist(emp);
		     flag=true;	
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}//catch
		finally {
			
			 if(flag) {
				 tx.commit();
				 System.out.println("Employee saved successfully..");
			 }
			 else {
				 tx.rollback();
				 System.out.println("Problem occured while saving Emp..");
			 }
			 
			 //close session
			 session.close();
			 //close factory
			 factory.close();
		}//finally
		
	}//main

}//class
