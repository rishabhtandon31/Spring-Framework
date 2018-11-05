package com.cg.banking.daoservices;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.util.EntityManagerFactoryProvider;

@Component(value="accountDAO")
public class AccountDAOImpl implements AccountDAO{
	@Autowired
	private EntityManagerFactory factory;

	@Override
	public long saveAccountDetails(Account account) {
		EntityManager entityManager= factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(account);
		entityManager.getTransaction().commit();
		entityManager.close();
		return account.getAccountNo();
	}

	@Override
	public Account getDetails(long accountNo) {
		EntityManager entityManager=factory.createEntityManager();
		return entityManager.find(Account.class, accountNo);
	}

	@Override
	public boolean updateAccount(Account account) {
		EntityManager entityManager= factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(account);
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	@Override
	public Transaction saveTransaction(long accountNo,float amount,String transactionType) {
		EntityManager entityManager= factory.createEntityManager();
		entityManager.getTransaction().begin();
		Account account= getDetails(accountNo);
		Transaction transaction= new Transaction(amount, transactionType, account);
		entityManager.persist(transaction);
		entityManager.getTransaction().commit();
		entityManager.close();
		return transaction;
	}

	@Override
	public List<Account> getAllAccountDetail() {
		EntityManager entityManager=factory.createEntityManager();
		Query query = entityManager.createQuery("from Account a");
		ArrayList<Account> list= (ArrayList<Account>) query.getResultList();
		return list;
	}

	@Override
	public List<Transaction> getAccountAllTransactions(long accountNo) {
		EntityManager entityManager=factory.createEntityManager();
		Query query = entityManager.createQuery("from Transaction a where ACCOUNT_ACCOUNTNO="+accountNo);
		ArrayList<Transaction> list= (ArrayList<Transaction>) query.getResultList();
		return list;
	}

	@Override
	public int pinNumberTrialsUpdate(long accountNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPinTrials(long accountNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean accountDelete(long accountNo) {
		Account account= getDetails(accountNo);
		EntityManager entityManager=factory.createEntityManager();
		entityManager.getTransaction().begin();
		account=entityManager.merge(account);
		entityManager.remove(account);
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	} 

	
}
