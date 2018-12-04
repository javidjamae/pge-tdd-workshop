package com.tdd.bank.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BankAccountInterestTest {
	
	
	@Test
	public void calculateInterest(){
		AccountService accountService = new AccountService("1234567890");
		
		try{
			//accountService.calculateInterest()
			assertEquals("Calculate interest for an account : ", 0.00, accountService.calculateInterest(), 0.1);
			//fail("Interest calculation failed");
		}
		catch(AccountTrasactionError e){
			assertEquals("Interest calculation failed",e.getMessage());   
		}
	}

}
