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
	
	@Test 
	public void withdrawMoreThanBalance() throws AccountTrasactionError {
		// setup
		Account account = new Account();
		account.deposit(10000);
		
		// execute
		try {
			account.withdraw(20000);
			fail("Should have thrown exception");
		} catch (AccountTrasactionError error) {
			assertEquals("Nice try. Not enough balance to cover the withdrawal", error.getMessage());
			assertEquals(10000, account.getBalanceInPennies());
		}
	}

	@Test 
	public void withdrawValidAmount() throws AccountTrasactionError {
		// setup
		Account account = new Account();
		account.deposit(10000);
		
		// execute
		account.withdraw(5000);
		assertEquals(5000, account.getBalanceInPennies());
	}

	@Test 
	public void withdrawNegativeAmount() throws AccountTrasactionError {
		// setup
		Account account = new Account();
		account.deposit(10000);
		
		// execute
		try {
			account.withdraw(-5000);
			fail("Should have thrown exception");
		} catch (AccountTrasactionError error) {
			assertEquals("Nice try again. Withdrawal amount cannot be negative", error.getMessage());
			assertEquals(10000, account.getBalanceInPennies());
		}
	}
}
