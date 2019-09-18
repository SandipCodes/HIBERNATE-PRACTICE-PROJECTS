package com.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Data
@Entity
//@Table(name="college")
public class College implements Serializable {

	/*@Id
	@GeneratedValue(generator="clg")
	@GenericGenerator(
			    name="clg" ,
			    strategy="org.hibernate.id.IncrementGenerator"
			    or strategy="increment"		)
	*/
	
	/*@Id
	@GeneratedValue(generator="clg")
	@GenericGenerator( name="clg",strategy="sequence")*/
/*	@Id
	@GeneratedValue(generator="clg")
	@GenericGenerator( name="clg",strategy="sequence",
	                        parameters=@Parameter(name="sequence_name",value="clg_seq"))
*/	
/*	@Id
	@GeneratedValue(generator="clg")
	@GenericGenerator( name="clg",strategy="identity")
*/
	/*@Id
	@GeneratedValue(generator="clg")
	@GenericGenerator( name="clg",strategy="org.hibernate.id.UUIDGenerator")*/
/*
	@Id
	@GeneratedValue(generator="clg")
	@GenericGenerator( name="clg",strategy="org.hibernate.id.GUIDGenerator")*/

	@Id
	@GeneratedValue(generator="clg")
	@GenericGenerator( name="clg",strategy="native")

	//private String code;
	private Integer code;
	private String name;
	private String city;
	private String grade;
    	
}
