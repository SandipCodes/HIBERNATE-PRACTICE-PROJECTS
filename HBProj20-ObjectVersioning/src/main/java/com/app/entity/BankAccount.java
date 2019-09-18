package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Data;

@Data
/*@Entity
@Table(name="bank_account")
*/
public class BankAccount {

/*	@Id
	@GeneratedValue
*/	private Integer accountNo;
	private String accountHolderName;
	private float accountBalance;
	private String accountType;
	private Integer version;
}//class
