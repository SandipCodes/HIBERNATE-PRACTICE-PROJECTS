package com.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
//@Table(name="college")
public class College implements Serializable {

/*	@Id //only @Id act as assigned type
 */
/*	@Id                //act as native or auto
	@GeneratedValue*/
/*	@Id   //same as above acts as native
	@GeneratedValue(strategy=GenerationType.AUTO)
*/	
/*	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
*/
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	/*
	@Id
	@SequenceGenerator(name="gen1",sequenceName="clg_seq2",initialValue=100,allocationSize=5)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)*/
	private Integer code;
	private String name;
	private String city;
	private String grade;
    	
}
