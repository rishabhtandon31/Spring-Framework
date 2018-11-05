package com.cg.banking.daoservices;

import java.sql.SQLException;
import java.util.List;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;

public interface AccountDAO {
	long saveAccountDetails(Account account);
	Account getDetails(long accountNo);
	boolean updateAccount(Account account);
	Transaction saveTransaction(long accountNo,float amount,String transactionType);
	List<Account> getAllAccountDetail();
	List<Transaction> getAccountAllTransactions(long accountNo);
	int pinNumberTrialsUpdate(long accountNo);
	int getPinTrials(long accountNo);
	boolean accountDelete(long accountNo);
}