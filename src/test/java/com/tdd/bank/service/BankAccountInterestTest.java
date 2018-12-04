package com.tdd.bank.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;

public class BankAccountInterestTest {
	
	@Test
	public void calculateInterest() {
		// setup
	//	BankAccount bankAccount = BankAccount.valueOf("MoneyMaket");
		
		AccountService accountService = new AccountService("1234567890");
   		
		assertEquals("compare the calculated interest: ", 0.00, accountService.calculateInterest(), 0.1);
	}
	
	

}
