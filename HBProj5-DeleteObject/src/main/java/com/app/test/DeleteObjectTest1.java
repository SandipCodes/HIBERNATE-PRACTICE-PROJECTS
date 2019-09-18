package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.Event;
import com.app.utils.HibernateUtil;

public class DeleteObjectTest1 {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction tx=null;
		Event e=null;
		boolean flag=false;
		
		
		//get session object
		
		session=HibernateUtil.getSession();
		
		//create Entity object
		 e=new Event();
		
		 e.setId(2);
		 
		 
		 
		 try {
			 tx=session.beginTransaction();
			 session.delete(e);
			 tx.commit();
			 flag=true;
		 }
		 catch(HibernateException he) {
			 tx.rollback();
			 he.printStackTrace();
		 }
		 catch(Exception ee) {
			 ee.printStackTrace();
		 }
		 finally {

			  if(flag) {
				  tx.commit();
				  System.out.println("Object DELETED");
			  }
			  else {
				  tx.rollback();
				  System.out.println("Object NOT FOUND");
			  }
           //close Session
			  HibernateUtil.closeSession(session);
			  //close factory
			  HibernateUtil.closeSessionFactory();
			 
		}//finally
	}//main()

}//class
