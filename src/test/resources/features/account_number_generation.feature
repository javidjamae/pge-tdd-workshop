Feature: Account number generation
  The rules behind account number generation
  
  Scenario: Account number issuing must start at 562738293
		Given no existing accounts in the system
		When I generate a new account number
		Then the account number should be 562738293
		
  Scenario: Account numbers must increment by three 
		Given one existing account in the system
		When I generate a new account number
		Then the account number should be three more than the highest existing account number