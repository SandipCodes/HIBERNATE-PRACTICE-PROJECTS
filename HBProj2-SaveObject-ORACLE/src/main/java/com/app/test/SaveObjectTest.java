package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.entity.Employee;

public class SaveObjectTest {

	public static void main(String[] args) {

		Configuration cfg = null;
		SessionFactory factory = null;
		Session session = null;
		Employee emp = null;
		Transaction tx = null;
		int id = 0;
		boolean flag = false;

		// bootstrap Hibernate
		cfg = new Configuration();

		// load cfg file and create in-mem-meta-Data
		cfg = cfg.configure("/com/app/cfgs/hibernate.cfg.xml");//

		// build SessionFactory
		factory = cfg.buildSessionFactory();

		// open session
		session = factory.openSession();

		emp = new Employee();

		emp.setId(101);
		emp.setEname("SACHIN");
		emp.setEmail("ssh321@gmail.com");
		emp.setSalary(8900078);

		try {
			tx = session.beginTransaction();
			id = (int) session.save(emp);
			flag = true;
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (flag) {
				tx.commit();
				System.out.println("Employee Saved with Id:" + id);
			} else {
				tx.rollback();
				System.out.println("Problem Occured while inserting Employee.");
			}
			// close session
			session.close();
			factory.close();

		}

	}// main

}// class
