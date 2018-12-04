package com.tdd.bank.service;

import com.tdd.bank.dao.BalanceDataAccessObject;

public class BalanceDataAccessObjectPseudo implements BalanceDataAccessObject {

	@Override
	public Integer getBalanceForAccount(String accountNumber) {
		throw new Error("shouldn't be called");
	}

	@Override
	public Integer getBalanceForAccount2(String accountNumber) {
		throw new Error("shouldn't be called");
	}

	@Override
	public Integer getBalanceForAccount3(String accountNumber) {
		throw new Error("shouldn't be called");
	}

	@Override
	public Integer getBalanceForAccount4(String accountNumber) {
		throw new Error("shouldn't be called");
	}

}
