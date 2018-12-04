package com.tdd.bank.service;

public class BalanceService {
	
	public String checkBalance(int balanceAmount) {
		if( balanceAmount < 50 ) {
			throw new BalanceAlertError("Low balance alert email sent");
		}
		return null;
	}


}
