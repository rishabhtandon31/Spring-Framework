package com.cg.banking.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "acc_sequence", sequenceName = "acc_seq", initialValue=5005001, allocationSize = 1000)
//@SequenceGenerator(name = "pin_sequence", sequenceName = "pin_seq", initialValue=1101, allocationSize = 1000)
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="acc_sequence")
	private long accountNo;

	//@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pin_sequence")
	private int pinNumber;
	private String accountType,status;
	private float accountBalance;

	@OneToMany(cascade=CascadeType.ALL ,mappedBy="account",fetch=FetchType.LAZY)
	private List<Transaction> transactions;
	public Account() {
		super();
	}

	public Account(int pinNumber, String accountType, String status,
			float accountBalance, List<Transaction> transactions) {
		super();
		this.pinNumber = pinNumber;
		this.accountType = accountType;
		this.status = status;
		this.accountBalance = accountBalance;
		this.transactions = transactions;
	}

	public Account(int pinNumber, String accountType, String status,
			float accountBalance) {
		super();
		this.pinNumber = pinNumber;
		this.accountType = accountType;
		this.status = status;
		this.accountBalance = accountBalance;
	}

	/*	public Account(String accountType, String status, float accountBalance) {
		super();
		this.accountType = accountType;
		this.status = status;
		this.accountBalance = accountBalance;
	}*/

	/*public Account(String accountType, String status,
			float accountBalance, List<Transaction> transactions) {
		super();
		this.accountType = accountType;
		this.status = status;
		this.accountBalance = accountBalance;
		this.transactions = transactions;
	}*/
	public Account(long accountNo, int pinNumber, String accountType,
			String status, float accountBalance, List<Transaction> transactions) {
		super();
		this.accountNo = accountNo;
		this.pinNumber = pinNumber;
		this.accountType = accountType;
		this.status = status;
		this.accountBalance = accountBalance;
		this.transactions = transactions;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public int getPinNumber() {
		return pinNumber;
	}
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", pinNumber=" + pinNumber
				+ ", accountType=" + accountType + ", status=" + status
				+ ", accountBalance=" + accountBalance; //+ ", transactions="+ transactions + "]";
	}

}