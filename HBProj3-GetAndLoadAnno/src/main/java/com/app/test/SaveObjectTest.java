package com.app.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.entity.InsurancePolicy;

public class SaveObjectTest {

	public static void main(String[] args) {
	
		Configuration cfg=null;
		SessionFactory factory=null;
		Session session=null;
		InsurancePolicy policy=null;
		
		Transaction tx=null;
		boolean flag=false;
		
		//bootstrap hibernate
		cfg=new Configuration();
		
		//load cfgs and prepare inmem meta data
		cfg=cfg.configure("/com/app/cfgs/hibernate.cfg.xml");
		
		//build session factory
		factory=cfg.buildSessionFactory();
		
		//open Session
		session=factory.openSession();
		
		//create ENtity Class obj
		policy=new InsurancePolicy();
		
		policy.setPolicyId(10002);
		policy.setPolicyHolderName("ANITA");
		//policy.setPolicyName("");
		policy.setAadharNo(0213l);
		policy.setTenure(20);
		
		
		try {
		
			 tx=session.beginTransaction();
			 session.save(policy);
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
				
			}
			
			//closing session
			session.close();
			//closing factory
			factory.close();
		}//finally
	}//main

}//class
