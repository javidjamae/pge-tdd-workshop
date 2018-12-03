package com.tdd.bank.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;

public class BankAccountInterestTest {
	
	@Test
	public void calculateInterest() {
		// setup
		BankAccount bankAccount = BankAccount.valueOf("MoneyMaket");
		double principal = 10.00;
		double amount = 0.00;
		
		

		try {
			// execute
			
			amount = principal * (1+2.3*12);
		
			fail("should have thrown exception");
		} catch (AccountCreationError e) {
			// verify
			assertEquals("interest must great than 0", e.getMessage());
		}
	
	}

}
