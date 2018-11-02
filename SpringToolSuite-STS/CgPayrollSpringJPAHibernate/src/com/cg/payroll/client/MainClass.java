package com.cg.payroll.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.payroll.beans.*;
import com.cg.payroll.exceptions.*;
import com.cg.payroll.services.*;

public class MainClass {
	private static PayrollServices payrollServices = new PayrollServicesImpl();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String userChoice="y";
		int ch=0;
		while(userChoice.compareToIgnoreCase("y")==0){
			System.out.println("Payroll Services!\n1. Add Associate Details\n2. Get Total Salary of the Associate\n3. Retrieve the details of a specific Associate\n4. Retrieve all Associates details\nEnter your choice:");
			ch = sc.nextInt();
			switch(ch){
			case 1: 
				try {
					System.out.println("\nEnter the Associate Details:\nEnter First Name of Associate");
					String firstName = sc.next();
					System.out.println("Enter Last Name of Associate");
					String lastName = sc.next();
					System.out.println("Enter EmailID of Associate");
					String emailId = sc.next();
					sc.nextLine();
					System.out.println("Enter Department of Associate");
					String department = sc.nextLine();
					System.out.println("Enter Designation of Associate");
					String designation = sc.nextLine();
					System.out.println("Enter Pancard Number of Associate");
					String pancard = sc.next();
					System.out.println("Enter Yearly Investment of Associate");
					int yearlyInvestmentUnder8oC =sc.nextInt();
					System.out.println("Enter Basic Salary of Associate");
					double basicSalary = sc.nextDouble();
					System.out.println("Enter EPF of Associate");
					double epf = sc.nextDouble();
					System.out.println("Enter CompanyPF of Associate");
					double companyPf = sc.nextDouble();
					System.out.println("Enter Account Number of Associate");
					double accountNumber = sc.nextDouble();
					System.out.println("Enter Bank Name of Associate");
					String bankName = sc.next(); 
					System.out.println("Enter Bank Code of Associate");
					String ifscCode = sc.next();
					System.out.println("Associate details of associate id: " + payrollServices.acceptAssociateDetails(firstName, lastName, emailId, department, designation, pancard, yearlyInvestmentUnder8oC, basicSalary, epf, companyPf, accountNumber, bankName, ifscCode) + " successfully added.");					
				} catch (PayrollServicesDownException e) { e.printStackTrace(); }
				break;
				
			case 2: 
				try {
					System.out.println("Enter the Associate ID:");
					int assoId = sc.nextInt();
					System.out.println("Net Salary of the Associate: " + Math.round(payrollServices.calculateNetSalary(assoId)));
				} catch (AssociateDetailNotFoundException | PayrollServicesDownException e) {
					System.out.println("Error calculating the Net Salary");
					e.printStackTrace();
				}
				break;
				
			case 3:
				try {
					System.out.println("Enter the Associate ID:");
					int assoId = sc.nextInt();
					Associate associate = payrollServices.getAssociateDetails(assoId);
					payrollServices.calculateNetSalary(associate.getAssociateID());
					System.out.println(associate.toString());
//					printDetails(associate);
				} catch (AssociateDetailNotFoundException | PayrollServicesDownException e) {
					System.out.println("No Associate Details Found!");
					e.printStackTrace();
				}
				break;
				
			case 4:
				try {
					ArrayList<Associate> associate = payrollServices.getAllAssociatesDetails();
					for (int i=0;i<associate.size() ; i++){ 
						payrollServices.calculateNetSalary(associate.get(i).getAssociateID());
						System.out.println("Details of Associate with ID: " + associate.get(i).getAssociateID());
						System.out.println(associate.get(i).toString());
//						printDetails(associate.get(i));
					}
				} catch (PayrollServicesDownException |AssociateDetailNotFoundException e) {
					System.out.println("No Associate Details Found!");
					e.printStackTrace();
				}
				break;
				
			default:
				System.out.println("Enter valid choice");
				break;
			}
			System.out.println("\nDo you wanna continue(y/n):");
			userChoice = sc.next();
		}
		sc.close();
	}
	
	public static void printDetails(Associate associate){
		System.out.println("Associate ID: " + associate.getAssociateID() + "First Name: " + associate.getFirstName() + "Last Name: " + associate.getLastName() + "E-Mail: " + associate.getEmailId() + "Department: " + associate.getDepartment() + "Designation: " + associate.getDesignation() + "Net Salary: " + Math.round(associate.getSalary().getNetSalary()));
	}
}
