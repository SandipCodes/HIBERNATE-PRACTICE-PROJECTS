package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.BankAccount;
import com.app.utils.HibernateUtil;

public class DbTableRowToObjectSync {

	public static void main(String[] args) {
		
		Session ses=null;
		BankAccount account=null;
		Transaction tx=null;
		//get session
		ses=HibernateUtil.getSession();
		
		//start operations
		try {
			tx=ses.beginTransaction();
			account=ses.get(BankAccount.class, 3);
			System.out.println(account);
			
			Thread.sleep(8000);//change account data from DB
			
			ses.refresh(account);//this will update account with new db values
			System.out.println(account);
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
		
			//close session
			HibernateUtil.closeSession(ses);
            //close SessionFactory
			HibernateUtil.closeFactory();
		}//finally
	}//main()

}//class
