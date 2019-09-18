package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.BrandFactory;
import com.app.utils.HibernateUtil;

/**
 * Hello world!
 *
 */
public class SaveOrUpdateTest1 
{
    public static void main( String[] args )
    {
    	Session ses=null;
         Transaction tx=null;
     	BrandFactory brandFactory=null;
        boolean flag=false;
        
    	//get a session
    	ses=HibernateUtil.getSession();
    	
    	try {
    		tx=ses.beginTransaction();
    		brandFactory=new BrandFactory();
    		brandFactory.setCustomerId(3);
    		brandFactory.setCustomerAddress("MUMBAI");
    		brandFactory.setCustomerName("SALMAN KHAN");
    		brandFactory.setMobileNumber(77999);
    		brandFactory.setRewardPoints(200);
    		
    	 	//ses.saveOrUpdate(brandFactory);
    	    ses.saveOrUpdate(brandFactory); 
    		flag=true;	
    	}
    	catch(HibernateException he) {
    		he.printStackTrace();
    	}
    	catch(Exception  e) {
    		e.printStackTrace();
    	}
    	finally {
    		
    		   if(flag) {
    			   tx.commit();
    			   System.out.println("Object saved or Updated successfully..");
    		   }
    		   else {
    			   tx.rollback();
    			   System.out.println("Object is not saved Or Updated");
    		   }
    		   
    		   //close session
    		   HibernateUtil.closeSession(ses);
    		   //close SessionFactory
    		   HibernateUtil.closeSessionFactory();
    	}//finally
    }//main()
}//class
