package com.tdd.bank.service;

import com.tdd.bank.domain.Account;

public class AccountService {

	private Account account;

	private static final double INTEREST_RATE = 2.3;
	private static final int MONTHS = 12;
	private static final double N = 1 / 12;
	private static final int TERM_IN_TIME = 365;

	//TODO: Get rid of Account argument and make this stateless -jj
	public AccountService(Account account) {
		this.account = account;
	}

	//TODO: Move this into account -jj
	public double calculateInterest() throws AccountTrasactionError {

		try {
			double principal = account.getBalanceInPennies();
			double interestAmount = principal * (Math.pow((1 + INTEREST_RATE * MONTHS), N * TERM_IN_TIME));

			return interestAmount;
		} catch (NumberFormatException error) {
			throw new AccountTrasactionError("Interest calculation failed");
		}

	}

	//TODO: Move this into account -jj
	public double calculateInterestMonthly() throws AccountTrasactionError {
		return 0.00;
	}

}
