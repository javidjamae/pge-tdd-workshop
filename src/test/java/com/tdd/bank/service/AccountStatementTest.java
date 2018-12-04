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

}
