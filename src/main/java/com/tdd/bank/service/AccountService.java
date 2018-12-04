package com.tdd.bank.service;

import com.tdd.bank.domain.Account;

public class AccountService {
	
     public AccountService(String accountNumber)	{
    	 
    	 
    	 
     }
     
     public double calculateInterest() throws AccountTrasactionError  {
    	 Account account = new Account();
 		try {
 			account.getBalanceInPennies();
 			
 			
 		} catch (Exception error) {
 			throw new AccountTrasactionError("Interest calculation failed");
 		}
     return 0.00;
     }

}
