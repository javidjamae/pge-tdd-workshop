package com.tdd.bank.service;

import com.tdd.bank.dao.BalanceDataAccessObject;

public class BalanceDataAccessObjectPseudo implements BalanceDataAccessObject {

	@Override
	public Integer getBalanceForAccount(String accountNumber) {
		throw new Error("shouldn't be called");
	}

}
