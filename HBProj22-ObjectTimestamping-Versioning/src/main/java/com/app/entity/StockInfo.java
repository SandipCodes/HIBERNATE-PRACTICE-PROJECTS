package com.app.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="stock_info")
public class StockInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=10)
	@Type(type="int")
	private Integer stockId;
	
	@Column(length=15,nullable=false, unique=true)
	@Type(type="string")
	private String stockName;
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	private String company;
	
	@Column(length=10,nullable=false)
	@Type(type="int")
	private Integer price;
	
	@CreationTimestamp
	@Type(type="timestamp")
	private Timestamp listingTime;

	@UpdateTimestamp
	@Type(type="timestamp")
	private Timestamp lastUpdated;
	
	@Version
	@Type(type="int")
	@Column(length=10,nullable=false)
	private Integer updationCount;
}//StockInfo
