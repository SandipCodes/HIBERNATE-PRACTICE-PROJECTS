package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.ProgrammerProjectId;
import com.app.entity.ProgrammerProjectInfo;
import com.app.utils.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {

		Session ses = null;
		Transaction tx = null;
		boolean flag = false;
		ProgrammerProjectId id=null;
       ProgrammerProjectInfo info=null;
       
		// get session
		ses = HibernateUtil.getSession();
		//set composite Id 
		   id=new ProgrammerProjectId();
		   id.setPid(1001);
		   id.setProjId(101);
			
		   try {
			
			   info = ses.load(ProgrammerProjectInfo.class, id);
			   flag=true;
		   }   
		 catch (HibernateException he) {
				he.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			} finally {

				if (flag) {
					System.out.println("Object loaded Successfully.."+ info);
				} else {

					System.out.println("Object not found");
				}
				// close session
				HibernateUtil.closeSession(ses);
				// close SessionFactory
				HibernateUtil.closeFactory();

			} // finally

	}// main

}// class
