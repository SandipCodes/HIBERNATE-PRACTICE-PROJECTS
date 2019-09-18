package com.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name="college")
public class College implements Serializable {

	@Id
	@GeneratedValue(generator="clg")
	@GenericGenerator(
			    name="clg" ,
			    strategy="org.hibernate.id.IncrementGenerator"
			    
			)
	@Type(type="int")
	@Column(name="code", length=10,nullable=false)
	private Integer code;
	
	@Column(nullable=false)
	private String name;
	
	private String city;
	
	@Column(updatable=false)
	private String grade;
    	
}
