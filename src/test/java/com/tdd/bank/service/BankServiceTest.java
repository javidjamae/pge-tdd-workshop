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
			bankService.createAccount("Javid", "Jamae", 19999, "1234446789");
			fail("should have thrown exception");
		} catch (AccountCreationError e) {
			// verify
			assertEquals("Initial deposit must be $200.00 or greater", e.getMessage());
		}
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

	@Test
	public void invalidGovernmentId_tooBig() {
		// setup
		BankService bankService = new BankService();

		try {
			// execute
			bankService.createAccount("Javid", "Jamae", 23456, "123456667892");
			fail("should have thrown exception");
		} catch (AccountCreationError e) {
			// verify
			assertEquals("Government ID cannot be longer than 10 digits", e.getMessage());
		}
	}
	
	@Test
	public void retrieveBalanceAcNumTooShort(){
		BankService bankService = new BankService();
		try{
			bankService.retrieveBalance("123");
			fail("Retrieve Balance Should have thrown error");
		}
		catch(AccountTrasactionError e){
			assertEquals("Account number too short",e.getMessage());   
		}
	}
	
	@Test
	public void retrieveBalanceAcNumNull(){
		BankService bankService = new BankService();
		try{
			bankService.retrieveBalance(null);
			fail("Retrieve Balance Should have thrown error");
		}
		catch(AccountTrasactionError e){
			assertEquals("Account number is null",e.getMessage());   
		}
	}
	
	@Test
	public void retrieveBalanceAcNumTooLong(){
		BankService bankService = new BankService();
		try{
			bankService.retrieveBalance("446444646464646466");
			fail("Retrieve Balance Should have thrown error");
		}
		catch(AccountTrasactionError e){
			assertEquals("Account number too long",e.getMessage());   
		}
	}
	
	

}
