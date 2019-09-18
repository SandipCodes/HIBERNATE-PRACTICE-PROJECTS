package com.app.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.Event;
import com.app.utils.HibernateUtil;

public class DeleteObjectTest2 {

	public static void main(String[] args) {
		
		Session ses=null;
		Event e=null;
		Transaction tx=null;
		boolean flag=false;
		//get session 
		ses=HibernateUtil.getSession();
		
		e=ses.get(Event.class, 2);
		
		/*e=new Event();
		e.setDoe(new Date());e.setId(3000);
		e.setLocation("PUNE");e.setName("DIWALI");
		e.setPax(98862);
		*/
		
		if(e !=null) {
			
		
		try {
			tx=ses.beginTransaction();
			ses.delete(e);
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
		}
		finally {
			
			  if(flag) {
				  tx.commit();
				  System.out.println("Object Deleted Successfullyy..");
			  }
			  else {
				  tx.rollback();
			  }
		
			//close session
			HibernateUtil.closeSession(ses);
			//close factory
			HibernateUtil.closeSessionFactory();
		}//finalyy
	}
		else {
			  System.out.println("Object Not Found !!");
				
		}
	}//main()

}//class
