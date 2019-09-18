package com.app.entity;

public class Employee {

	private Integer id;
	private String ename;
	private String email;
	private Integer salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", email=" + email + ", salary=" + salary + "]";
	}
	
	
}//class
