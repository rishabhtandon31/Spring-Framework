package com.cg.payroll.beans;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Associate {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int associateID;
	private int yearlyInvestmentUnder8oC;
	private String firstName, lastName, department, designation, pancard, emailId; 
	@Embedded
	private BankDetails bankDetail;
	@Embedded
	private Salary salary;
	
	public Associate() {}
	
	public Associate(int associateID, int yearlyInvestmentUnder8oC,
			String firstName, String lastName, String department,
			String designation, String pancard, String emailId,
			BankDetails bankDetail, Salary salary) {
		super();
		this.associateID = associateID;
		this.yearlyInvestmentUnder8oC = yearlyInvestmentUnder8oC;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.designation = designation;
		this.pancard = pancard;
		this.emailId = emailId;
		this.bankDetail = bankDetail;
		this.salary = salary;
	}	
	
	public Associate(String firstName,
			String lastName, String department, String designation,
			String pancard, String emailId, int yearlyInvestmentUnder8oC, BankDetails bankDetail,
			Salary salary) {
		super();
		this.yearlyInvestmentUnder8oC = yearlyInvestmentUnder8oC;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.designation = designation;
		this.pancard = pancard;
		this.emailId = emailId;
		this.bankDetail = bankDetail;
		this.salary = salary;
	}

	public int getAssociateID() {
		return associateID;
	}

	public void setAssociateID(int associateID) {
		this.associateID = associateID;
	}

	public int getYearlyInvestmentUnder8oC() {
		return yearlyInvestmentUnder8oC;
	}

	public void setYearlyInvestmentUnder8oC(int yearlyInvestmentUnder8oC) {
		this.yearlyInvestmentUnder8oC = yearlyInvestmentUnder8oC;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public BankDetails getBankDetail() {
		return bankDetail;
	}

	public void setBankDetail(BankDetails bankDetail) {
		this.bankDetail = bankDetail;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + associateID;
		result = prime * result
				+ ((bankDetail == null) ? 0 : bankDetail.hashCode());
		result = prime * result
				+ ((department == null) ? 0 : department.hashCode());
		result = prime * result
				+ ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((pancard == null) ? 0 : pancard.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + yearlyInvestmentUnder8oC;
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
		Associate other = (Associate) obj;
		if (associateID != other.associateID)
			return false;
		if (bankDetail == null) {
			if (other.bankDetail != null)
				return false;
		} else if (!bankDetail.equals(other.bankDetail))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (pancard == null) {
			if (other.pancard != null)
				return false;
		} else if (!pancard.equals(other.pancard))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (yearlyInvestmentUnder8oC != other.yearlyInvestmentUnder8oC)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Associate [associateID=" + associateID + ", yearlyInvestmentUnder8oC=" + yearlyInvestmentUnder8oC + ", firstName=" + firstName + ", lastName=" + lastName + ", department=" + department + ", designation=" + designation + ", pancard=" + pancard + ", emailId=" + emailId + ", bankDetail=" + bankDetail.toString() + ", salary=" + salary.toString() +"]";
	}
}
