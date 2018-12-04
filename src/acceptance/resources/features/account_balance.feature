Feature: As a bank teller I can retrieve an account balance
  By providing an account number, a bank teller can retreive a customer's account balance
  
  Scenario: Valid account, returns balance
    Given a valid account with a balance of $10.23
    When I ask for my account balance
    Then the account balance is $10.23
    
  Scenario: Invalid account number, throws exception
  		Given an invalid account number
		When I ask for my account balance
    Then an invalid account error occurs
    
  Scenario: Non-existent account number, throws exception
  		Given an invalid account number
		When I ask for my account balance
    Then an invalid account error occurs