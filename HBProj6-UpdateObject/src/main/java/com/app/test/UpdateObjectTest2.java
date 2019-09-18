package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.BankAccount;
import com.app.utils.HibernateUtil;

public class UpdateObjectTest2 {

	public static void main(String[] args) {

		Session ses = null;
		BankAccount account = null;
		Transaction tx = null;
		boolean flag = false;

		// get session
		ses = HibernateUtil.getSession();
		// load object and then update data
		account = ses.load(BankAccount.class, 3);

		if (account != null) {

			// setting new value to update
		
			try {
				tx = ses.beginTransaction();
				account.setAccountType("CURRENT");
				account.setAccountBalance(1999999);
				ses.update(account);
				flag = true;
			} catch (HibernateException he) {
				he.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			} finally {

				if (flag) {
					tx.commit();
					System.out.println("Object updated Successfully..");
				} else {
					tx.rollback();

				}
				// close session
				HibernateUtil.closeSession(ses);
				// close SessionFactory
				HibernateUtil.closeFactory();

			} // finally

		} // if
		else {
			System.out.println("OBJECT NOT FOUND..");
		}
	}// main

}// class
