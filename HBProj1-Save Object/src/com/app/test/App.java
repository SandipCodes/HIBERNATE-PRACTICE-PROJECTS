package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.model.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg=null;
    	SessionFactory factory=null;
    	Session session=null,session2=null;
    	Person person=null;
         Transaction tx=null;       
    	
         //create Config
         cfg=new Configuration();
     
    	//create SessionFactory Object
          cfg=cfg.configure("/com/app/cfg/hibernate.cfg.xml");
          
          //factory
          factory=cfg.buildSessionFactory();
          //get a session 
            session=factory.openSession();
          //setting the person values
    
            person=new Person();
            person.setId(101);
            person.setFirstName("SANDIP");
            person.setLastName("HUMBE");
            person.setPhoneNumber(7878L);
            
            //begin transaction
            try {
            	 tx=session.beginTransaction();
            	 session.save(person);
            	 tx.commit();
            	 System.out.println("Object is saved:");
            }
            catch(HibernateException he) {
            	tx.rollback();
            	he.printStackTrace();
            	
            }
    
            //close session
            session.close();
           //close SessionFactory
            factory.close();
    }//main
}//class
