package com.tdd.bank.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class DepositTest {
	@Test
	public void checkCheckingNumber_Is_blank() {
		// setup
		BankService bankService = new BankService();

		try {
			// execute
			bankService.depositCheck("0123", null, 213L, "12/04/2018");
			fail("should have thrown exception");
		} catch (AccountCreationError e) {
			// verify
			assertEquals("Checking account Number cannot be blank",
					e.getMessage());
		}
	}

	@Test
	public void checkCheckingNumber_Is_valid_length() {
		// setup
		BankService bankService = new BankService();

		try {
			// execute
			bankService.depositCheck("0123", "1231", 213L, "12/04/2018");
			fail("should have thrown exception");
		} catch (AccountCreationError e) {
			// verify
			assertEquals(
					"Checking account Number should be between 8 and 12 digits",
					e.getMessage());
		}

	}

	@Test
	public void checkCheckingNumber_startWithZero() {
		// setup
		BankService bankService = new BankService();

		try {
			// execute
			bankService.depositCheck("0123", "01235123", 213L, "12/04/2018");
			fail("should have thrown exception");
		} catch (AccountCreationError e) {
			// verify
			assertEquals("Checking account Number cannot start with 0",
					e.getMessage());
		}

	}

}