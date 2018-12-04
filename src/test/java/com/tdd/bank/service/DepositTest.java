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
			bankService.depositCheck("0123", null,213L, "12/04/2018");
			fail("should have thrown exception");
		} catch (AccountCreationError e) {
			// verify
			assertEquals("Checking account Number cannot be blank", e.getMessage());
		}

}
	public void checkDepositAmount() {
		// setup

		try {
			// execute
			 
			fail("should have thrown exception");
		} catch (AccountCreationError e) {
			// verify
			assertEquals("Deposit fail", e.getMessage());
		}

}
	
}