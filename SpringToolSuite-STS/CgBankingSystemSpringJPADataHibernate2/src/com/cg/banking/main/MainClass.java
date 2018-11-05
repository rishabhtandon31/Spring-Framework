package com.cg.banking.main;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;

public class MainClass {
	static ApplicationContext applicationContext= new ClassPathXmlApplicationContext("projectbeans.xml");
	private static BankingServices bankingServices = (BankingServices) applicationContext.getBean("bankingServices");
		private static Scanner sc = new Scanner(System.in);
		public static void main(String[] args) {
			
			String wannaContinue="y";
			int userChoice=0;
			while(wannaContinue.equalsIgnoreCase("y")){
				try {
					System.out.println("Select any one of the following:\n1. Open an Account\n2.Deposit an Amount\n3. Withdraw an Amount\n4.Transfer to another account.\n5.Get a specific Account Details\n6. Get All Account details\n7. Get Account Transactions\n8. Get Account Status\n9. Delete The Account\n Select your choice:");
					userChoice = sc.nextInt();
					sc.nextLine();
					switch(userChoice) {
						case 1:
							System.out.println("\nOpening the Account!\nEnter the account type:");
							String accountType = sc.nextLine();
							System.out.println("Enter the balance to transfer to new account:");
							float initBalance = sc.nextFloat();
							System.out.println("Enter the pinNumber:");
							int pinNumber = sc.nextInt();
							long accountNo = bankingServices.openAccount(accountType, initBalance,pinNumber);
							System.out.println("Congratulations! The account is successfully opened. Your account number is " + accountNo);
							break;
							
						case 2:
							System.out.println("\nDeposit Window\nEnter the account number:");
							accountNo = sc.nextLong();
							System.out.println("Enter the amount to deposit");
							float amount = sc.nextFloat();
							float finalBalance = bankingServices.depositAmount(accountNo, amount);
							System.out.println("The amount has been deposited. The updated balance in the account is Rs. "+finalBalance);
							break;
							
						case 3:
							System.out.println("\nWithdraw Window\nEnter the account number:");
							accountNo = sc.nextLong();
							System.out.println("Enter the amount to be withdrawn");
							amount = sc.nextFloat();
							System.out.println("Enter your pin number:");
							pinNumber = sc.nextInt();
							finalBalance = bankingServices.withdrawAmount(accountNo, amount, pinNumber);
							System.out.println("The amount has been withdrawn. The updated balance in the account is Rs. "+finalBalance);
							break;
							
						case 4:
							System.out.println("\nTransfer to another Account\nEnter the account number of the receipent.");
							long accountNoTo = sc.nextLong();
							System.out.println("Enter your account number");
							long accountNoFrom = sc.nextLong();
							System.out.println("Enter the amount to transfer");
							float transferAmount = sc.nextFloat();
							System.out.println("Enter your pin number");
							pinNumber = sc.nextInt();
							if (bankingServices.fundTransfer(accountNoTo, accountNoFrom, transferAmount, pinNumber))
								System.out.println("The funds got successfully transfered");
							break;
							
						case 5:
							System.out.println("\nAccount Details!\nEnter your account number:");
							accountNo = sc.nextLong();
							System.out.println(bankingServices.getAccountDetails(accountNo).toString());
							break;
							
						case 6:
							System.out.println("\nGet all Accounts");
							List<Account> accounts = bankingServices.getAllAccountDetails();
							for (Account account: accounts)	System.out.println(account.toString());
							break;
							
						case 7:
							System.out.println("\nGet all Account Transactions\nEnter your account number:");
							accountNo = sc.nextLong();
							List<Transaction> transactions = bankingServices.getAccountAllTransaction(accountNo);
							for (Transaction transaction : transactions)	System.out.println(transaction.toString());
							break;
							
						case 8: 
							System.out.println("Enter the account no: ");
							accountNo= sc.nextLong();
							System.out.println("Your Account status: "+bankingServices.accountStatus(accountNo));
							break;
						case 9:
							System.out.println("Enter the account no. to delete : ");
							accountNo=sc.nextLong();
							if(bankingServices.accountDelete(accountNo)==1)
								System.out.println("Account with account no. "+accountNo+" deleted.");
						default:
							System.out.println("Enter a valid choice");
							break;
					}
				} catch (BankingServicesDownException e) { System.out.println(e.getMessage());
				} catch (AccountBlockedException e) { System.out.println(e.getMessage());
				} catch (AccountNotFoundException e) { System.out.println(e.getMessage());
				} catch (InsufficientAmountException e) { System.out.println(e.getMessage());
				} catch (InvalidAccountTypeException e) { System.out.println(e.getMessage());
				} catch (InvalidAmountException e) { System.out.println(e.getMessage());
				} catch (InvalidPinNumberException e) { System.out.println(e.getMessage()); }
				System.out.println("\nDo you wanna continue(y/n):");
				wannaContinue = sc.next();
				}
				sc.close();
		} 
	}

