Feature: User can retrieve account balance
  By providing an account number, the user can retreive their account balance

  Scenario: Valid account, returns balance
    Given a valid account number with a balance of $10.23
    When I ask for my account balance
    Then the balance is $10.23
    
  Scenario: Invalid account number, throws exception
  		Given an invalid account number
		When I ask for my account balance
    Then an invalid account error occurs
    
  Scenario: Non-existent account number, throws exception
  		Given an invalid account number
		When I ask for my account balance
    Then an invalid account error occurs