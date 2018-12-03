package com.tdd.bank.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class BankServiceTest {

	@Test
	public void depositUnder200() {
		// setup
		BankService bankService = new BankService();

		try {
			// execute
			bankService.createAccount("Javid", "Jamae", 19999, "123444");
			fail("should have thrown exception");
		} catch (AccountCreationError e) {
			// verify
			assertEquals("Initial deposit must be $200.00 or greater", e.getMessage());
		}

	}

	private void fail(String string) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void invalidGovernmentId_tooShort() {
		// setup
		BankService bankService = new BankService();

		try {
			// execute
			bankService.createAccount("Javid", "Jamae", 23456, "3");
			fail("should have thrown exception");
		} catch (AccountCreationError e) {
			// verify
			assertEquals("Government ID cannot be shorter than 10 digits", e.getMessage());
		}
	}

}
