package com.app.entity;

import java.sql.Timestamp;

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
	private Timestamp lastUpdated;
	
}//class
