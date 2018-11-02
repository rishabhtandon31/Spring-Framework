package com.cg.payroll.services;
import java.util.ArrayList;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.exceptions.AssociateDetailNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;

public interface PayrollServices {
	int acceptAssociateDetails(String firstName, String lastName, String emailId, String department, String designation, String pancard, int yearlyInvestmentUnder8oC, double basicSalary, double epf, double companyPf, double accountNumber, String bankName, String ifscCode) throws PayrollServicesDownException;
	double calculateNetSalary(int associateId) throws AssociateDetailNotFoundException, PayrollServicesDownException;
	Associate getAssociateDetails(int associateId) throws AssociateDetailNotFoundException, PayrollServicesDownException;
	ArrayList<Associate> getAllAssociatesDetails() throws PayrollServicesDownException;
}
