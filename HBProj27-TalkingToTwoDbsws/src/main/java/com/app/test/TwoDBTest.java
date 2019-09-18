package com.app.test;

import com.app.dao.EmployeeDao;
import com.app.dao.EmployeeDaoFactory;
import com.app.utility.MySqlHibernateUtil;
import com.app.utility.OracleHibernateUtil;

public class TwoDBTest {

	public static void main(String[] args) {
		EmployeeDao dao=null;
		
		//get Dao
		dao=EmployeeDaoFactory.getInstance();
		//invoke method
		dao.transferEmployee(107);
				  //close factory
		  OracleHibernateUtil.closeFactory();
		  MySqlHibernateUtil.closeFactory();
		
	}//main

}//class
