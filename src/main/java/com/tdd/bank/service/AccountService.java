package com.tdd.bank.service;

import com.tdd.bank.domain.Account;

public class AccountService {

	 Account account;
	 
	 final double INTEREST_RATE=2.3;
	 final double N = 1/12;
	 final int TERM_IN_TIME = 365;
	 
     public AccountService(String accountNumber)	{
    	 Account account = new Account(accountNumber);
    	 this.account = account;
    	 
     }
     public AccountService(Account account)	{
    	 
    	this.account = account;
    	 
     }
     private int getAccountTerm(){
    	 return 1;
     }
     
     public double calculateInterest() throws AccountTrasactionError  {
    	 
    	 
 		try {
 			double principal = account.getBalanceInPennies();
 			//double interestAmount = accountBalance *(1+INTEREST_RATE/N)^N*TERM_IN_TIME 
 			double interestAmount = principal * (Math.pow((1+INTEREST_RATE*12), 1/12 * 365));
 			
 			return interestAmount;
 		} catch (Exception error) {
 			throw new AccountTrasactionError("Interest calculation failed");
 		}
 
     }
     public double calculateInterestMonthly() throws AccountTrasactionError  {
    	 return 0.00;
     }

}
