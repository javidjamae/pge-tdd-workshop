package com.tdd.bank.service;

public class BankService {

	public void setAccountNumberGenerator(AccountNumberGenerator generator) {
	}
	
	public String createAccount(String firstName, String lastName, int depositInCents, String governmentIdNumber) {
		if( depositInCents < 20000 ) {
			throw new AccountCreationError("Initial deposit must be $200.00 or greater");
		}
		if( governmentIdNumber.length() < 10 ) {
			throw new AccountCreationError("Government ID cannot be shorter than 10 digits");
		}
		return null;
	}

}