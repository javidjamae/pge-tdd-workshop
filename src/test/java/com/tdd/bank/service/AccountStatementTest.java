package com.tdd.bank.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tdd.bank.domain.AccountStatement;

public class AccountStatementTest {

	@Test
	public void validateStatementCreation_new() {
		// setup
		BankService bankService = new BankService();

		// execute
		AccountStatement statement = bankService.generateStatement("9999999999", "Jan", "2018");

		// verify
		assertEquals("9999999999", statement.getAccountNumber());
		assertEquals("2018", statement.getYear());
		assertEquals("Jan", statement.getMonth());
	}

	/*
	 * 
	 * @Test public void validateGovtIdGreater10Digit() { // setup BankService
	 * bankService = new BankService();
	 * 
	 * try { // execute bankService.createAccount("Javid", "Jamae", 20000,
	 * "12344434343"); // fail("should have thrown exception"); } catch
	 * (AccountCreationError e) { // verify assertEquals(
	 * "Government ID cannot be longer than 10 digits", e.getMessage()); } }
	 * 
	 * @Test public void validateGovtIdInvalidNumber() { // setup BankService
	 * bankService = new BankService();
	 * 
	 * try { // execute bankService.createAccount("Javid", "Jamae", 20000,
	 * "12W1443433"); fail("Valid number"); // fail(
	 * "should have thrown exception"); } catch (AccountCreationError e) { //
	 * verify assertEquals("Government ID should be valid 10 digits number",
	 * e.getMessage()); } }
	 * 
	 * @Test public void success() { // setup BankService bankService = new
	 * BankService(); AccountNumberGenerator generator = new
	 * AccountNumberGenerator() {
	 * 
	 * @Override public String generateAccountNumber() { return "987654321"; }
	 * }; bankService.setAccountNumberGenerator(generator);
	 * 
	 * // execute String accountNumber = bankService.createAccount("Javid",
	 * "Jamae", 20000, "3456789012");
	 * 
	 * // verify assertEquals("987654321", accountNumber);
	 * 
	 * }
	 */
}
