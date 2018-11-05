package com.cg.banking.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAO;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;

@Component(value="bankingServices")
public class BankingServicesImpl implements BankingServices {
	static int pinNumberTry=0;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Override
	public long openAccount(String accountType, float initBalance, int pinNumber)
			throws InvalidAmountException, InvalidAccountTypeException,
			BankingServicesDownException {
		try {
			if(!(accountType.equalsIgnoreCase("Savings") || accountType.equalsIgnoreCase("Current")))
				throw new InvalidAccountTypeException("Account type is not valid. Choose only Savings or Current");
			if(initBalance <1000)
				throw new InvalidAmountException("Balance should be more than 1000Rs. !!!");
			else{
				String status="Active";
				Account account= new Account(pinNumber, accountType, status, initBalance);
				List<Transaction> transactions= new ArrayList<Transaction>();
				Transaction transaction= new Transaction(initBalance, "Deposit", account);
				transactions.add(transaction);
				account.setTransactions(transactions);
				long accountNo;
				accountNo=accountDAO.saveAccountDetails(account);
				if (accountNo==0)
					throw new BankingServicesDownException("Servers ae down! try again after some time");
				return accountNo;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BankingServicesDownException("Server is down. Please try again later");
		}
	}

	@Override
	public float depositAmount(long accountNo,float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		try {
			Account account = accountDAO.getDetails(accountNo);
			if(account == null) throw new AccountNotFoundException("Account details not found. Enter your account no. again");
			Transaction transaction= accountDAO.saveTransaction(accountNo, amount, "Deposit");
			account.setAccountBalance(account.getAccountBalance() + amount);
			boolean updateAccount= accountDAO.updateAccount(account);
			if(updateAccount)
				return account.getAccountBalance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
	AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		Account account;
		try {
			account = accountDAO.getDetails(accountNo);
			if(account == null) throw new AccountNotFoundException("Account details not found. Enter your account no. again");
			if(account.getStatus().equalsIgnoreCase("Locked")) throw new AccountBlockedException("Your Account Blocked!!");
			
			//pinNumberTry= accountDAO.getPinTrials(accountNo);
			
/*			if(account.getPinNumber() != pinNumber && pinNumberTry ==3){
				account.setStatus("Locked");
				accountDAO.updateAccount(account);
				throw new InvalidPinNumberException("Your account get locked...!!!");
			}

			if(account.getPinNumber() != pinNumber && pinNumberTry <3){
				pinNumberTry=accountDAO.pinNumberTrialsUpdate(accountNo);
				System.out.println("Your Pin Trials "+pinNumberTry);
				throw new InvalidPinNumberException("Wrong Pin Number. Try again !!!");
			}
*/		
			if(account.getPinNumber() != pinNumber)
				throw new InvalidPinNumberException("Wrong Pin Number. Try again !!!");
			
			Transaction transaction= accountDAO.saveTransaction(accountNo, amount, "Withdraw");
			account.setAccountBalance(account.getAccountBalance() - amount);
			boolean updateAccount= accountDAO.updateAccount(account);
			if(updateAccount)
				return account.getAccountBalance();
					} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException {
		try {
			Account account;
			account = accountDAO.getDetails(accountNoTo);
			if(account == null) throw new AccountNotFoundException("Wrong account number. Enter the recepient account number again!!!");
			account = accountDAO.getDetails(accountNoFrom);
			if(account==null) throw new AccountNotFoundException("Wrong account number. Enter the your account number again!!!");
			withdrawAmount(accountNoFrom, transferAmount, pinNumber);
			depositAmount(accountNoTo, transferAmount);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServicesDownException {
		Account account;
		try {
			account = accountDAO.getDetails(accountNo);
			if(account == null) throw new AccountNotFoundException("Account not found!!!");
			return account;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AccountNotFoundException("Account not found!!!");
		}
	}

	@Override
	public List<Account> getAllAccountDetails() throws BankingServicesDownException {
		try{
			List<Account> accounts= accountDAO.getAllAccountDetail();
			return accounts;
		}catch (Exception e) {
			e.printStackTrace();
			throw new BankingServicesDownException("Servers are down. Try gain after sometime.");
		}
	}

	@Override
	public List<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException {
		try{
			List<Transaction> transactions= accountDAO.getAccountAllTransactions(accountNo);
			if(transactions.isEmpty())
				throw new AccountNotFoundException("Account Not Found. Try again!!!");
			return transactions;
		}catch (Exception e) {
			e.printStackTrace();
			throw new BankingServicesDownException("Servers are down. Try gain after sometime.");
		}
	}

	@Override
	public String accountStatus(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
		try {
			Account account = accountDAO.getDetails(accountNo);
			if(account==null) throw new AccountNotFoundException("Account Not Found. Please Try Again!!!");
			return account.getStatus();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AccountNotFoundException("Account not found!!!");
		}
	}

	@Override
	public int accountDelete(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException {
		boolean result =accountDAO.accountDelete(accountNo);
		if(result==true)
			return 1;
		else return 0;
	}

	
}
