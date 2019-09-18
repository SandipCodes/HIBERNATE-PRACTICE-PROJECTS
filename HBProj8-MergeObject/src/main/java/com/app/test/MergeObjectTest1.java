package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.BrandFactory;
import com.app.utils.HibernateUtil;

public class MergeObjectTest1 {

	public static void main(String[] args) {
	
		Session ses=null,ses2=null;
		Transaction tx=null;
		BrandFactory brandFactory=null,bf2=null;
		boolean flag=false;
		
		//get session
		ses=HibernateUtil.getSession();
		ses2=HibernateUtil.getSession();
  
		
		
		
		try {
		    brandFactory=ses.get(BrandFactory.class, 6);
		    
		    ses.close();
		    brandFactory.setCustomerAddress("UK");
		    
		    
		    //bf2=ses2.get(BrandFactory.class, 6);
		    //bf2.setCustomerName("RITESH");
		    //bf2.setMobileNumber(777777);
		    tx=ses2.beginTransaction();
		     
		    brandFactory=(BrandFactory) ses2.merge(brandFactory);
		    System.out.println("After Merge:" + brandFactory);
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
				 System.out.println("Object merged successfullyy..");
			 }
			 else {
				 tx.rollback();
				 System.out.println("Object not merged successfullyy..");
			 }
		}//finally
	}//main

}//class
