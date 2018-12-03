package com.pge.bank.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class BankServiceAccountCreationTest {

	@Test
	public void successfulAccountCreation() {
		// setup
		String accountNumberToReturn = "123456789";
		BankService bankService = createBankService(accountNumberToReturn);

		// execute
		String actualAccountNumber = bankService.createAccount("Javid", "Jamae", 200000, "4567890123");

		// verify
		assertEquals(accountNumberToReturn, actualAccountNumber);
	}

	@Test
	public void successfulAccountCreationWithDifferentAccountNumber() {
		// setup
		String accountNumberToReturn = "234567890";
		BankService bankService = createBankService(accountNumberToReturn);

		// execute
		String accountNumber = bankService.createAccount("Javid", "Jamae", 200000, "4567890123");

		// verify
		assertEquals("234567890", accountNumber);
	}

	@Test
	public void depositTooSmall() {
		// setup
		String accountNumberToReturn = "234567890";
		BankService bankService = createBankService(accountNumberToReturn);

		// execute
		try {
			bankService.createAccount("Javid", "Jamae", 19999, "5678901234");
			fail("should have thrown error");
		} catch (AccountCreationError e) {
			assertEquals("Initial deposit must be $200.00 or greater", e.getMessage());
		}
	}

	@Test
	public void firstNameBlank() {
		// setup
		String accountNumberToReturn = "234567890";
		BankService bankService = createBankService(accountNumberToReturn);

		// execute
		try {
			bankService.createAccount("", "Jamae", 29999, "5678901234");
			fail("should have thrown error");
		} catch (AccountCreationError e) {
			assertEquals("First name is invalid", e.getMessage());
		}
	}

	@Test
	public void firstNameNull() {
		// setup
		String accountNumberToReturn = "234567890";
		BankService bankService = createBankService(accountNumberToReturn);

		// execute
		try {
			bankService.createAccount(null, "Jamae", 29999, "5678901234");
			fail("should have thrown error");
		} catch (AccountCreationError e) {
			assertEquals("First name is invalid", e.getMessage());
		}
	}

	private BankService createBankService(String accountNumber) {
		AccountNumberGenerator generator = new AccountNumberGenerator() {
			@Override
			public String generateAccountNumber() {
				return accountNumber;
			}
		};
		BankService bankService = new BankService();
		bankService.setAccountNumberGenerator(generator);
		return bankService;
	}
}
