package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.entity.InsurancePolicy;

public class LoadObjectTest {

	public static void main(String[] args) {
		Configuration cfg = null;
		SessionFactory factory = null;
		Session session = null;
		InsurancePolicy policy = null;

		// bootstrap hibernate
		cfg = new Configuration();

		// load cfg file
		cfg = cfg.configure("/com/app/cfgs/hibernate.cfg.xml");

		// set properties through program

		cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test2");
		cfg.setProperty("hibernate.connection.username", "root");
		cfg.setProperty("hibernate.connection.password", "root");
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		cfg.setProperty("connection.pool_size", "4");
		cfg.setProperty("sql_show", "true");
		cfg.setProperty("format_sql", "true");
		cfg.setProperty("cache.provider_class", "org.hibernate.cache.NoCacheProvider");

		
		//specify mapping file
		cfg.addFile("src/main/java/com/app/cfgs/InsurancePolicy.hbm.xml");
		// Create Session factory
		factory = cfg.buildSessionFactory();

	
		// open Session
		session = factory.openSession();

		// load entity class obj

		try {
			policy = session.load(InsurancePolicy.class, 3);
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (policy != null) {
				System.out.println("Object Found:" + policy);
			} else {
				System.out.println("Object Not Found..");
			}

			// close session
			session.close();

			// close factory
			factory.close();
		}
	}// main

}// class
