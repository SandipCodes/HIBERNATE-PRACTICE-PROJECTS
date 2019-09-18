package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.StockInfo;
import com.app.utils.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {

		Session ses = null;
		StockInfo stockInfo=null;
		Transaction tx = null;
		boolean flag = false;

		// get session
		ses = HibernateUtil.getSession();
		// load object and then update data
		stockInfo = ses.load(StockInfo.class, 14);

		if (stockInfo != null) {

			// setting new value to update
                stockInfo.setPrice(3500);
			  
			try {
				
				tx = ses.beginTransaction();
                ses.update(stockInfo);
                flag=true;
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
