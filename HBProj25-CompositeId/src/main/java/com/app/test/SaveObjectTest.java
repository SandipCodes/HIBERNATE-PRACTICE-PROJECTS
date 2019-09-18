package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.ProgrammerProjectId;
import com.app.entity.ProgrammerProjectInfo;
import com.app.utils.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		
		Session ses=null;
		ProgrammerProjectId id=null, idVal=null;
		ProgrammerProjectInfo info=null;
		Transaction tx=null;
		boolean flag=false;
		
		//get session 
		ses=HibernateUtil.getSession();
		
		//create object
		id=new ProgrammerProjectId();
		id.setPid(1002);
		id.setProjId(102);
		
		info=new ProgrammerProjectInfo();
		info.setId(id);
        info.setProgrammerName("SACHIN");
        info.setProjectName("E-COMMERCE");
		try {
			tx=ses.beginTransaction();
			idVal=(ProgrammerProjectId) ses.save(info);
			ses.flush();
			System.out.println("Generated idVal:"+idVal);
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
				  System.out.println("Object Saved Successfully with Composite It ..");
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
