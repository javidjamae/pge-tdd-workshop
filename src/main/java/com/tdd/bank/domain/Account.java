package com.tdd.bank.domain;

import com.tdd.bank.service.AccountTrasactionError;

public class Account {
	
	private int balanceInPennies;

	public int getBalanceInPennies() {
		return balanceInPennies;
	}

	public void deposit(int deposit) throws AccountTrasactionError {
		if (deposit  < 0) {
			throw new AccountTrasactionError("Deposit amount must be positive");
		}
		this.balanceInPennies = this.balanceInPennies+ deposit;
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
	
}
