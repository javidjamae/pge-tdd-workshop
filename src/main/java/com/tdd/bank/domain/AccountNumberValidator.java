package com.tdd.bank.domain;

import com.tdd.bank.service.AccountTrasactionError;

public class AccountNumberValidator {

	public static void validateAccountNumber(String accountNumber) {
		if(accountNumber == null){
			throw new AccountTrasactionError("Account number is null");
		}
		if(accountNumber.length()<10){
			throw new AccountTrasactionError("Account number too short");
		}
		if(accountNumber.length()>10){
			throw new AccountTrasactionError("Account number too long");
		}
	}
}
