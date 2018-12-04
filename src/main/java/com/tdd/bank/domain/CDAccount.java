package com.tdd.bank.domain;

import java.util.Date;

public class CDAccount extends Account {

	public long accountNumber;
	double despositAmt;
	String firstName;
	String lastName;

	String accountType;
	double maturedCDAmount;

	public double getMaturedCDAmount() {
		return maturedCDAmount;
	}

	public void setMaturedCDAmount(double maturedCDAmount) {
		this.maturedCDAmount = maturedCDAmount;
	}

	Date maturityDate; // Date to withdraw

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public int getMaturityTerm() {
		return maturityTerm;
	}

	public void setMaturityTerm(int maturityTerm) {
		this.maturityTerm = maturityTerm;
	}

	int maturityTerm;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getDespositAmt() {
		return despositAmt;
	}

	public void setDespositAmt(double despositAmt) {
		this.despositAmt = despositAmt;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
