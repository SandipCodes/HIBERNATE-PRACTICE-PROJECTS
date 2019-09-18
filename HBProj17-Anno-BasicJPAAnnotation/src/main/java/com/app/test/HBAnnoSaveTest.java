package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.College;
import com.app.util.HibernateUtil;

public class HBAnnoSaveTest {

	public static void main(String[] args) {
		
		Session ses=null;
		College college=null;
		Transaction tx=null;
		boolean flag=false;
		
		//open a session
		ses=HibernateUtil.getSession();
		
		try {
			 //begin transaction
		    tx=ses.beginTransaction();
		    //create entity obj
		    college=new College();
		    
		    college.setName("SCOE");
		    college.setCity("PUNE");
		    college.setGrade("A");
		    
		    int idVal=(int) ses.save(college);
		    System.out.println("generated Id Val:"+idVal);
		 
		   flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
		
			 if(flag) {
				 tx.commit();
				 System.out.println("Object saved Successfully..");
			 }
			 else {
				 tx.rollback();
				 System.out.println("Object not saved..");
			 }
			 
			 //clsoe session
			 HibernateUtil.closeSession(ses);
			 //close SessionFactory
			 HibernateUtil.closeSessionFactory();
		}//finally
				
	}//main()

}//class
