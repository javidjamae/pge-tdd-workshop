package com.tdd.bank.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

	@Test
	public void getBalance() {
		// setup
		Account account = new Account();
		account.setBalanceInPennies(10000);
		
		// execute and verify
		assertEquals(10000, account.getBalanceInPennies());
		
	}

}
