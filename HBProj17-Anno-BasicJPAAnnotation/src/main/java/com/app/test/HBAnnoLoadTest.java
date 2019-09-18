
package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.app.entity.College;
import com.app.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class HBAnnoLoadTest 
{
    public static void main( String[] args )
    {
      
    	Session ses=null;
    	College college=null;
    	boolean flag=false;
    	
    	//get session
    	ses=HibernateUtil.getSession();
    	
    	try {
    		college=ses.load(College.class, 2);
    //		System.out.println("Object Found:"+college);
    	    flag=true;
    	}//try
    	catch(HibernateException he) {
    		he.printStackTrace();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	finally {
    		if(flag) {
    			System.out.println("Object Found:"+college);		
    		}
    		else {
    		   System.out.println("Object Not found..");
    		}
    	}//finally
    	
    }//main
}//class
