package com.app.generators;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomCuponIdGenerators implements IdentifierGenerator {

	public CustomCuponIdGenerators() {
	System.out.println("CustomCuponIdGenerators.CustomCuponIdGenerators()");
	}
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		System.out.println("CustomCuponIdGenerators.generate()");
	
		Random rad=null;
		int val=0;
		
		rad=new Random();
		
		val=rad.nextInt(10000);
		
		return val;
	}//generate

}//class
