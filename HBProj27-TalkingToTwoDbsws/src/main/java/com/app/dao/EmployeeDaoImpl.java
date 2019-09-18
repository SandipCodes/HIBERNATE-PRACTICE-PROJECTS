package com.app.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.Employee;
import com.app.utility.MySqlHibernateUtil;
import com.app.utility.OracleHibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void transferEmployee(int eno) {
		
		Session oraSession=null,mysqlSession=null;
		Employee emp=null;
		Transaction tx1=null,tx2=null;
		boolean flag=false;
		//get an session
		oraSession=OracleHibernateUtil.getSession();
		mysqlSession=MySqlHibernateUtil.getSession();
		
		//load object from Oracle
		emp=oraSession.get(Employee.class, new Integer(eno));
		
		if(emp== null) {
			System.out.println("Object with Id:"+eno+ "  Not Found");
			return;
		}
		//transfer employee from oracle to mysql
		try {
			 
			  tx1=oraSession.beginTransaction();
			  tx2=mysqlSession.beginTransaction();
			  mysqlSession.save(emp);
			  oraSession.delete(emp);
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
				  tx1.commit();
				  tx2.commit();
				  System.out.println("Object Transfered successfully");
			  }
			  else {
				  tx1.rollback();
				  tx2.rollback();
				System.out.println("Problem Occured while transferin Object");
			  }
			  
			  //close sessions
			  OracleHibernateUtil.closeSession(oraSession);
			  MySqlHibernateUtil.closeSession(mysqlSession);
			  
		}//finally
	}//method

}//class
