package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.LuckyDrawCupon;
import com.app.util.HibernateUtil;

public class CustomGeneratorsTest {

	public static void main(String[] args) {
		
		Session ses=null;
		LuckyDrawCupon cupon=null;
		
		Transaction tx=null;
		boolean flag=false;
		
		//open a session
		ses=HibernateUtil.getSession();
		
		try {
			 //start transaction
		     tx=ses.beginTransaction();
		     
		   //create entity object
		       cupon=new LuckyDrawCupon();
		       cupon.setCustName("SANDIP");
		       cupon.setCustAddr("PUNE");
		       cupon.setCustMobileNo(7709595657l);
		     String idVal=(String) ses.save(cupon);
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
