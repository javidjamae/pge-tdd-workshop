package com.pge.bank.service;

public class BankService {

	private AccountNumberGenerator generator;
	
	public void setAccountNumberGenerator(AccountNumberGenerator generator) {
		this.generator = generator;
	}

	public String createAccount(String firstName, String lastName, int depositInCents, String governmentIdNumber) {
		if ( depositInCents < 20000 ) {
			throw new AccountCreationError("Initial deposit must be $200.00 or greater");
		}
		if ( firstName == "" || firstName == null) {
			throw new AccountCreationError("First name is invalid");
		}
		return generator.generateAccountNumber();
	}

}