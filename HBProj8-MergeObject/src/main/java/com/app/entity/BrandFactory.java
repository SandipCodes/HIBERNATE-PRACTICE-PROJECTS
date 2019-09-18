package com.app.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class BrandFactory implements Serializable {

	private Integer customerId;
	private String customerName;
	private String customerAddress;
	private long mobileNumber;
	private Integer rewardPoints;
}//class
