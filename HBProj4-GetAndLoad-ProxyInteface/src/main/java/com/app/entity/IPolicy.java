package com.app.entity;

public interface IPolicy {


	public Integer getPolicyId();
	public void setPolicyId(Integer policyId);
	
	public String getPolicyName();
    public void setPolicyName(String policyName);
	
    public String getPolicyHolderName();
    public void setPolicyHolderName(String policyHolderName);

	public Integer getTenure() ;
	public void setTenure(Integer tenure);
	
	public Long getAadharNo();
    public void setAadharNo(Long aadharNo);
}
