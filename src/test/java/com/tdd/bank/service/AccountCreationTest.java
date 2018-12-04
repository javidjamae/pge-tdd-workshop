package com.tdd.bank.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountCreationTest {

	@Test
	public void validateGovtIdLess10Digit() {
		// setup
		BankService bankService = new BankService();

		try {
			// execute
			bankService.createAccount("Javid", "Jamae", 20000, "123444");
			// fail("should have thrown exception");
		} catch (AccountCreationError e) {
			// verify
			assertEquals("Government ID cannot be shorter than 10 digits", e.getMessage());
		}
	}

	@Test
	public void validateGovtIdGreater10Digit() {
		// setup
		BankService bankService = new BankService();

		try {
			// execute
			bankService.createAccount("Javid", "Jamae", 20000, "12344434343");
			// fail("should have thrown exception");
		} catch (AccountCreationError e) {
			// verify
			assertEquals("Government ID cannot be longer than 10 digits", e.getMessage());
		}
	}

	@Test
	public void validateGovtIdInvalidNumber() {
		// setup
		BankService bankService = new BankService();

		try {
			// execute
			bankService.createAccount("Javid", "Jamae", 20000, "12W1443433");
			fail("Valid number");
			// fail("should have thrown exception");
		} catch (AccountCreationError e) {
			// verify
			assertEquals("Government ID should be valid 10 digits number", e.getMessage());
		}
	}

	@Test
	public void success() {
		// setup
		BankService bankService = new BankService();
		AccountNumberGenerator generator = new AccountNumberGenerator() {
			@Override
			public String generateAccountNumber() {
				return "987654321";
			}
		};
		bankService.setAccountNumberGenerator(generator);

		// execute
		String accountNumber = bankService.createAccount("Javid", "Jamae", 20000, "3456789012");

		// verify
		assertEquals("987654321", accountNumber);

	}
}
