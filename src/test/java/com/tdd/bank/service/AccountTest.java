package com.tdd.bank.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.tdd.bank.domain.Account;

public class AccountTest {

	@Test
	public void checkBalanceAfterDeposit() throws AccountTrasactionError {
		// setup
		Account account = new Account();
		account.deposit(10000);
		
		// execute and verify
		assertEquals(10000, account.getBalanceInPennies());
	}

	@Test
	public void checkBalanceAfter2Deposits() throws AccountTrasactionError {
		// setup
		Account account = new Account();
		account.deposit(10000);
		
		account.deposit(20000);
		
		// execute and verify
		assertEquals(30000, account.getBalanceInPennies());
	}

	@Test
	public void invalidNegativeDepositAmount() {
		// setup
		Account account = new Account();
		try {
		// execute
			account.deposit(-10000);
			fail("Should have thrown exception");
		} catch (AccountTrasactionError error) {
			assertEquals("Deposit amount must be positive", error.getMessage());
		}
	}
}
