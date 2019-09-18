package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.BankAccount;
import com.app.utils.HibernateUtil;

public class UpdateObjectTest1 {

	public static void main(String[] args) {
		
		Session ses=null;
		BankAccount b=null;
		Transaction tx=null;
		boolean flag=false;
		
		//get session 
		ses=HibernateUtil.getSession();
		//create object
		b=new BankAccount();
		
		b.setAccountBalance(2222222);
	  //	b.setAccountHolderName("SACHIN");
		b.setAccountNo(4);
		b.setAccountType("SAVING");
		
		
		try {
			tx=ses.beginTransaction();
			ses.update(b);
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
				  System.out.println("Object updated Successfully..");
			  }
			  else {
				  System.out.println("Obejct not updated..");
			  }
			//close session
			HibernateUtil.closeSession(ses);
			//close SessionFactory
			HibernateUtil.closeFactory();
			
		}//finally
		
	}//main

}//class
