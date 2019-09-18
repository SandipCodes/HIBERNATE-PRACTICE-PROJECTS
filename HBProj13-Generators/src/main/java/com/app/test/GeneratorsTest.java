package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.Student;
import com.app.util.HibernateUtil;

public class GeneratorsTest {

	public static void main(String[] args) {
		
		Session ses=null;
		Student s1=null;
		Transaction tx=null;
		boolean flag=false;
		
		//open a session
		ses=HibernateUtil.getSession();
		
		try {
			 //start transaction
		     tx=ses.beginTransaction();
		     
		   //create entity object
		     s1=new Student();
		     //s1.setId(103);
		     s1.setName("SANDIP");
		     s1.setEmail("sandip11@gmail.com");
		     s1.setCity("PUNE");
		     
		     int idVal= (int) ses.save(s1);
			 System.out.println("Generated id value::"+idVal);
             flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			
			 if(flag) {
				 tx.commit();
				 System.out.println("Object Saved Succcessfully..");
			 }
			 else {
				 tx.rollback();
				 System.out.println("Object not saved Successfully.");
			 }
			 
			 //close session
			 HibernateUtil.closeSession(ses);
			 //close Sessionfactory
			 HibernateUtil.closeSessionFactory();
		}//finally
	}//main()

}//class
