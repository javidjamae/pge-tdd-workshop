package com.tdd.bank.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tdd.bank.domain.Account;

public class BankAccountInterestTest {
	
	
	@Test
	public void calculateInterest(){
		Account account = new Account("1234567890");
		account.setBalanceInPennies(2000);
		AccountService accountService = new AccountService(account);
		
		
		try{
			double interestAmt = accountService.calculateInterest();
			assertEquals("Calculate interest for an account : ", 2000.00, interestAmt, 0.1);
			//fail("Interest calculation failed");
		}
		catch(AccountTrasactionError e){
			assertEquals("Interest calculation failed",e.getMessage());   
		}
	}
	@Test
	public void calculateInterestMonthly(){
		Account account = new Account("1234567890");
		account.setBalanceInPennies(2000);
		AccountService accountService = new AccountService(account);
		
		
		try{
			double interestAmt = accountService.calculateInterestMonthly();
			assertEquals("Calculate interest for an account : ", 0.00, interestAmt, 0.1);
			//fail("Interest calculation failed");
		}
		catch(AccountTrasactionError e){
			assertEquals("Interest calculation failed",e.getMessage());   
		}
	}
}
