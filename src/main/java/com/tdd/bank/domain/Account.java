package com.tdd.bank.domain;

import java.util.Date;

import com.tdd.bank.service.AccountTrasactionError;

public class Account {

	private String accountNo;
	private int balanceInPennies;
	Date createDate; // Date created is date deposited

	// TODO: Get rid of default ctor
	public Account() {
	}

	// TODO: Get rid of default ctor
	public Account(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public int getBalanceInPennies() {
		return balanceInPennies;
	}

	public void setBalanceInPennies(int balanceInPennies) {
		this.balanceInPennies = balanceInPennies;
	}

	public void deposit(int deposit) throws AccountTrasactionError {
		if (deposit < 0) {
			throw new AccountTrasactionError("Deposit amount must be positive");
		}
		this.balanceInPennies = this.balanceInPennies + deposit;
	}

	public void withdraw(int withdrawalAmount) throws AccountTrasactionError {
		if (withdrawalAmount > this.balanceInPennies) {
			throw new AccountTrasactionError("Nice try. Not enough balance to cover the withdrawal");
		}

		if (withdrawalAmount < 0) {
			throw new AccountTrasactionError("Nice try again. Withdrawal amount cannot be negative");
		}

		this.balanceInPennies = this.balanceInPennies - withdrawalAmount;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
