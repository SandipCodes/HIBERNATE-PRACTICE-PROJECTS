package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="insurance_policy")
@Data
@NoArgsConstructor
public class InsurancePolicy {

	@Id
	@GeneratedValue
	@Column(name="policy_id")
	private Integer policyId;

	@Column(name="policy_name",nullable=false, length=25)
	private String policyName;
	
	@Column(name="policy_hldr_name",length=25)
	private String policyHolderName;
	
	@Column(name="tenure", length=2)
	private Integer tenure;

	@Column(name="aadhar_no",unique=true,length=12)
	private Long aadharNo;
	
	
}
