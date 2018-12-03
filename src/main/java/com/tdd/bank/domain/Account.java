package com.tdd.bank.domain;

import com.tdd.bank.service.AccountTrasactionError;

public class Account {
	
	private int balanceInPennies;

	public int getBalanceInPennies() {
		return balanceInPennies;
	}

	public void addDepositBalanceInPennies(int deposit) throws AccountTrasactionError {
		if (deposit  < 0) {
			throw new AccountTrasactionError("Deposit amount must be positive");
		}
		this.balanceInPennies = this.balanceInPennies+ deposit;
	}
	
}
