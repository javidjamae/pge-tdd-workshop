package com.tdd.bank.service;

public class BankService {

	public void setAccountNumberGenerator(AccountNumberGenerator generator) {
	}
	
	public String createAccount(String firstName, String lastName, int depositInCents, String governmentIdNumber) {
		
		 if( governmentIdNumber.length() < 10 ) {
			throw new AccountCreationError("Government ID cannot be shorter than 10 digits");
		}
		else if( governmentIdNumber.length() > 10 ) {
			throw new AccountCreationError("Government ID cannot be longer than 10 digits");
		}else if( governmentIdNumber.length() == 10 ) {
			try{
				Integer.parseInt(governmentIdNumber);
				
			}catch(Exception e){
				throw new AccountCreationError("Government ID should be valid 10 digits number");
			}
			
			
		}
	 
		return null;
	}

}