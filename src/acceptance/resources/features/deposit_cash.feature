Feature: Deposit cash into account
  I should be able to deposit cash into an account

  Scenario: Deposit $20.00 cash
    Given a valid account with a balance of $10.23
    When I deposit $20.00 cash
      And I ask for my account balance
    Then the account balance is $30.23
    		And the deposit status is marked as "Success" 
