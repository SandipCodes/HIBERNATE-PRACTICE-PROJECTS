package com.app.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Student implements Serializable {

	 private String id;
	 private String name;
	 private String email;
	 private String city;
	 
	 
}
