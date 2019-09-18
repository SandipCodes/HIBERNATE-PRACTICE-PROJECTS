package com.app.entity;

import java.io.Serializable;

public final class InsurancePolicy implements Serializable, IPolicy {

	private Integer policyId;
	private String policyName;
	private String policyHolderName;
	private Integer tenure;
	private Long aadharNo;
	
	public InsurancePolicy() {
		System.out.println("InsurancePolicy.InsurancePolicy()");
	}

	public InsurancePolicy(Integer policyId) {
		System.out.println("InsurancePolicy.InsurancePolicy()");
		this.policyId = policyId;
	}

	public Integer getPolicyId() {
		System.out.println("InsurancePolicy.getPolicyId()");
		return policyId;
	}

	public void setPolicyId(Integer policyId) {
		System.out.println("InsurancePolicy.setPolicyId()");
		this.policyId = policyId;
	}

	public String getPolicyName() {
		System.out.println("InsurancePolicy.getPolicyName()");
		return policyName;
	}

	public void setPolicyName(String policyName) {
		System.out.println("InsurancePolicy.setPolicyName()");
		this.policyName = policyName;
	}

	public String getPolicyHolderName() {
		System.out.println("InsurancePolicy.getPolicyHolderName()");
		return policyHolderName;
	}

	public void setPolicyHolderName(String policyHolderName) {
		System.out.println("InsurancePolicy.setPolicyHolderName()");
		this.policyHolderName = policyHolderName;
	}

	public Integer getTenure() {
		System.out.println("InsurancePolicy.getTenure()");
		return tenure;
	}

	public void setTenure(Integer tenure) {
		System.out.println("InsurancePolicy.setTenure()");
		this.tenure = tenure;
	}

	public Long getAadharNo() {
		System.out.println("InsurancePolicy.getAadharNo()");
		return aadharNo;
	}

	public void setAadharNo(Long aadharNo) {
		System.out.println("InsurancePolicy.setAadharNo()");
		this.aadharNo = aadharNo;
	}

	@Override
	public String toString() {
		return "InsurancePolicy [policyId=" + policyId + ", policyName=" + policyName + ", policyHolderName="
				+ policyHolderName + ", tenure=" + tenure + ", aadharNo=" + aadharNo + "]";
	}
	

	
}//class
