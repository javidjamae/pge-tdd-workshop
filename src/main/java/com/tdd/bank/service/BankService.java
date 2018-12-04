package com.tdd.bank.service;

public class BankService {

	private AccountNumberGenerator generator;

	public void setAccountNumberGenerator(AccountNumberGenerator generator) {
		this.generator = generator;
	}

	public String createAccount(String firstName, String lastName,
			int depositInCents, String governmentIdNumber) {

		validateGovernmentID(governmentIdNumber);
		validateDeposit(depositInCents);
		validateFirstName(firstName);
		validateLastName(lastName);

		return generator.generateAccountNumber();
	}

	private void validateDeposit(int depositInCents) {
		if (depositInCents < 20000) {
			throw new AccountCreationError(
					"Initial deposit must be $200.00 or greater");
		}
	}

	private void validateGovernmentID(String governmentIdNumber) {
		if (governmentIdNumber.length() < 10) {
			throw new AccountCreationError(
					"Government ID cannot be shorter than 10 digits");
		}

		if (governmentIdNumber.length() > 10) {
			throw new AccountCreationError(
					"Government ID cannot be longer than 10 digits");
		}

		try {
			Long.parseLong(governmentIdNumber);
		} catch (Exception e) {
			throw new AccountCreationError(
					"Government ID should be valid 10 digits number");
		}
	}

	private void validateFirstName(String firstName) {
		if (firstName == null) {
			throw new AccountCreationError("First name cannot be null");
		} else if (firstName.length() < 4) {
			throw new AccountCreationError("First name is too short");
		} else if (firstName.length() > 25) {
			throw new AccountCreationError("First name is too long");
		}
	}

	private void validateLastName(String lastName) {
		if (lastName == null) {
			throw new AccountCreationError("Last name cannot be null");
		} else if (lastName.length() < 4) {
			throw new AccountCreationError("Last name is too short");
		} else if (lastName.length() > 25) {
			throw new AccountCreationError("Last name is too long");
		}
	}

	public int getBalanceForAccount(String accountNumber) {
		throw new Error("not yet implemented");
	}

	public void deposit(String accountNumber, int amountInPennies) {
		throw new Error("not yet implemented");
	}

	public void withdraw(String accountNumber, int amountInPennies) {
		throw new Error("not yet implemented");
	}

}