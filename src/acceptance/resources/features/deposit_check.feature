Feature: Deposit check into account
  I should be able to deposit a check into an account

  Scenario: Deposits of $500.00 and more are marked as Pending
    Given a valid check routing number
    	 And a valid check account number
    	 And a check date in the past
    	 And a check amount of $2000.00
    When I deposit the check into an account with a balance of $200.00 
      And I ask for my account balance
    Then the account balance is $200.00
    		And the deposit status is marked as "Pending"
    		
  Scenario: Deposits of less than $500.00 are marked as "Available"
    Given a valid check routing number
    	 And a valid check account number
    	 And a check date in the past
    	 And a check amount of $200.00
    When I deposit the check into an account with a balance of $200.00 
      And I ask for my account balance
    Then the account balance is $400.00
    		And the deposit status is marked as "Available"

    		
  Scenario: Deposits of $10000.00 and over are sent to the FBI
    Given a valid check routing number
    	 And a valid check account number
    	 And a check date in the past
    	 And a check amount of $10000.00
    When I deposit the check into an account with a balance of $200.00 
      And I ask for my account balance
    Then the account balance is $200.00
    		And the deposit status is marked as "Pending"
    		And the transaction id is logged in our Send to FBI list
    		