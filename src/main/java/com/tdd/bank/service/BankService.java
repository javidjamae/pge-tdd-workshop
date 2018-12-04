package com.tdd.bank.service;

import com.tdd.bank.dao.BalanceDataAccessObject;

public class BankService {

	private AccountNumberGenerator generator;
	private BalanceDataAccessObject balanceDAO;

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
	
	/**
	 * validating checking account number(between 8 to 12, cannot start with 0)
	 * @param checkingNumber
	 */
	private void validateCheckingNumber(String checkingNumber){
		
		if (checkingNumber == null) {
			throw new AccountCreationError("Checking account Number cannot be blank");
		} else if (checkingNumber.length() < 7 && checkingNumber.length() > 12) {
			throw new AccountCreationError("Checking account Number should be between 8 and 12 digits");
		} else if (checkingNumber.startsWith("0")) {
			throw new AccountCreationError("Checking account Number cannot start with 0");
		}
		
		try{
			Long.parseLong(checkingNumber);
		}
		catch(NumberFormatException nfe){
			throw new AccountCreationError("Checking account Number should be Numeric");
		}		
		
	}
		
	
	public void depositCheck(String customerAccoutNumber, String checkingNumber,long routingNumber, String date) {
		validateCheckingNumber(checkingNumber);
	}

	public int getBalanceForAccount(String accountNumber) {
		throw new Error("not yet implemented");
	}

	public void deposit(String accountNumber, int amountInPennies) {
		throw new Error("not yet implemented");
	}

	public void withdraw(String actualAccountNumber, int i) {
		throw new Error("not yet implemented");
	}

	public Integer retrieveBalance(String accountNumber) throws AccountTrasactionError {
		
		Integer balance = null;
		if(accountNumber == null){
			throw new AccountTrasactionError("Account number is null");
		}
		if(accountNumber.length()<10){
			throw new AccountTrasactionError("Account number too short");
		}
		if(accountNumber.length()>10){
			throw new AccountTrasactionError("Account number too long");
		}
		
		balance = balanceDAO.getBalanceForAccount(accountNumber);
		
		return balance;
	}

	public BalanceDataAccessObject getBalanceDAO() {
		return balanceDAO;
	}

	public void setBalanceDAO(BalanceDataAccessObject balanceDAO) {
		this.balanceDAO = balanceDAO;
	}

}