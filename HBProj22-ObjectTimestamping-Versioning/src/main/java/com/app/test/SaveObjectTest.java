package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.StockInfo;
import com.app.utils.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		
		Session ses=null;
		StockInfo stockInfo=null;
		Transaction tx=null;
		boolean flag=false;
		
		//get session 
		ses=HibernateUtil.getSession();
		//create object
	
		 stockInfo=new StockInfo();
		 
	     	
		
		try {
			tx=ses.beginTransaction();
		     //set values for entity class object
			stockInfo.setCompany("HCL");
			stockInfo.setPrice(1600);
			stockInfo.setStockName("HCLSTOCK");
		
			ses.save(stockInfo);
			ses.flush();
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
				  tx.rollback();
				  System.out.println("Obejct not updated..");
			  }
			//close session
			HibernateUtil.closeSession(ses);
			//close SessionFactory
			HibernateUtil.closeFactory();
			
		}//finally
		
	}//main

}//class
