package com.tdd.bank.service;

public class BankService {
	
	private AccountNumberGenerator generator;

	public void setAccountNumberGenerator(AccountNumberGenerator generator) {
		this.generator = generator;
	}

	public String createAccount(String firstName, String lastName, int depositInCents, String governmentIdNumber) {

		if (depositInCents < 20000) {
			throw new AccountCreationError("Initial deposit must be $200.00 or greater");
		}

		if (governmentIdNumber.length() < 10) {
			throw new AccountCreationError("Government ID cannot be shorter than 10 digits");
		}

		if (governmentIdNumber.length() > 10) {
			throw new AccountCreationError("Government ID cannot be longer than 10 digits");
		}

		try {
			Long.parseLong(governmentIdNumber);
		} catch (Exception e) {
			throw new AccountCreationError("Government ID should be valid 10 digits number");
		}

		return generator.generateAccountNumber();
	}

}