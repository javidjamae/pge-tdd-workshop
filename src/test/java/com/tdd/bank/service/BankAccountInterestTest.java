package com.tdd.bank.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tdd.bank.domain.Account;

public class BankAccountInterestTest {

	@Test
	public void calculateInterest() throws AccountTrasactionError {
		Account account = new Account("1234567890");
		account.setBalanceInPennies(2000);
		
		//TODO: Services shouldn't be stateful, don't pass in data
		AccountService accountService = new AccountService(account);

		double interestAmt = accountService.calculateInterest();
		assertEquals("Calculate interest for an account : ", 2000.00, interestAmt, 0.1);
	}

	@Test
	public void calculateInterestMonthly() throws AccountTrasactionError {
		Account account = new Account("1234567890");
		account.setBalanceInPennies(2000);
		AccountService accountService = new AccountService(account);

		double interestAmt = accountService.calculateInterestMonthly();
		assertEquals("Calculate interest for an account : ", 0.00, interestAmt, 0.1);
	}
}
