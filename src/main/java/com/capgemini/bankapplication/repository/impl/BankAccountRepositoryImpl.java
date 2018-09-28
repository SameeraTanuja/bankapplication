package com.capgemini.bankapplication.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.bankapplication.repository.BankAccountRepository;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public double getBalance(long accountId) {
		// TODO Auto-generated method stub
		double balance=jdbcTemplate.queryForObject("SELECT accountBalance FROM bankaccounts WHERE accountId=?", new Object[]{accountId}, Double.class);
		
		return balance;
	
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		// TODO Auto-generated method stub
		double balance=jdbcTemplate.queryForObject("select accountBalance from bankaccounts where accountId=?", new Object[] {accountId},Double.class);
		if(balance+newBalance>=0)
		if(jdbcTemplate.update("update bankaccounts set accountBalance = ? where accountId = ?", new Object[] {newBalance+balance,accountId})!=0)
		{
			return true;
		}
		return false;
		
	}

	}
	


