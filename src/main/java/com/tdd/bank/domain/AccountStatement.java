package com.tdd.bank.domain;

public class AccountStatement {

	private String accountNumber ;
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
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}


}
