package com.app.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomNITIDGenarator implements IdentifierGenerator {

	 private String GET_SEQ_NO="SELECT STU_SEQ.NEXTVAL FROM DUAL";
	public CustomNITIDGenarator() {
	  System.out.println("CustomNITIDGenarator.CustomNITIDGenarator()");
	}
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
	    
		System.out.println("CustomNITIDGenarator.generate()");
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int val=0;
		
		try {
			 
			 con=session.connection();
			 
			 if(con!=null) {
				 ps=con.prepareStatement(GET_SEQ_NO);
			 }
			 if(ps!=null) {
				 rs=ps.executeQuery();
			 }
			 
			 if(rs!=null) {
				 rs.next();
				 val=rs.getInt(1);
			 }
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(val <=9)
			 return "NIT000"+val;
		else if(val<=99)
			return "NIT00"+val;
		else if(val<=999)
			return "NIT0"+val;
		else
			return "NIT"+val;
	
	}//method

}//class
