Feature: Deposit into account
  I should be able to deposit money into an account by check or by cash

  Scenario: Deposit $20.00 cash
    Given a valid account with a balance of $10.23
    When I deposit $20.00 cash
      And I ask for my account balance
    Then the account balance is $30.23
    		And the deposit status is marked as "Success" 

  Scenario: Deposit $20.00 by check
    Given a valid account with a balance of $10.23
    When I deposit $20.00 by check
      And I ask for my account balance
    Then the account balance is $10.23
    		And the deposit status is marked as "Pending"