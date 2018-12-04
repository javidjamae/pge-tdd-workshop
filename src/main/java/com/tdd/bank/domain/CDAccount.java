package com.tdd.bank.domain;

public class CDAccount extends Account {

	private double despositAmt;
	private String accountType;

	public double getDespositAmt() {
		return despositAmt;
	}

	public void setDespositAmt(double despositAmt) {
		this.despositAmt = despositAmt;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}