package com.tdd.bank.domain;

public class AccountStatement {

	private String accountNumber;
	private String month;
	private String year;

	public AccountStatement(String accountNumber, String month, String year) {
		this.accountNumber = accountNumber;
		this.month = month;
		this.year = year;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

}