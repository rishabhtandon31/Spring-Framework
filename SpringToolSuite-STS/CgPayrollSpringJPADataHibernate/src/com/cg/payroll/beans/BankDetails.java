package com.cg.payroll.beans;

import javax.persistence.Embeddable;

@Embeddable
public class BankDetails {
	private double accountNumber;
	private String bankName, ifscCode;
	
	public BankDetails() {
		super();
	}
	
	public BankDetails(double accountNumber, String bankName, String ifscCode) {
		super();
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
	}
	
	public double getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getIfscCode() {
		return ifscCode;
	}
	
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accountNumber);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result
				+ ((ifscCode == null) ? 0 : ifscCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankDetails other = (BankDetails) obj;
		if (Double.doubleToLongBits(accountNumber) != Double
				.doubleToLongBits(other.accountNumber))
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (ifscCode == null) {
			if (other.ifscCode != null)
				return false;
		} else if (!ifscCode.equals(other.ifscCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BankDetails [accountNumber=" + accountNumber + ", bankName=" + bankName + ", ifscCode=" + ifscCode + "]";
	}
}
