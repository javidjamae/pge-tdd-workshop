Feature: Account Creation
  I can create a new account

  Scenario: Successful account creation
    Given a valid government id number
    		And an initial deposit of $200.00
    		And a valid first name
    		And a valid last name
    When I attempt to create an account
    Then the account creation is successful
      And the account number is valid

  Scenario: Deposit too small
    Given a valid government id number
    		And an initial deposit of $199.99
    		And a valid first name
    		And a valid last name
    When I attempt to create an account
    Then the account creation is unsuccessful
      And the error is "Initial deposit must be $200.00 or greater"

  Scenario: First name is invalid
    Given a valid government id number
    		And an initial deposit of $299.99
    		And an invalid first name
    		And a valid last name
    When I attempt to create an account
    Then the account creation is unsuccessful   
      And the error is "First name is invalid"     

  Scenario: Last name is invalid
    Given a valid government id number
    		And an initial deposit of $299.99
    		And a valid first name
    		And an invalid last name
    When I attempt to create an account
    Then the account creation is unsuccessful         
      And the error is "Last name is invalid"

  Scenario Outline: Validity of government id number
    Given a government id number of <govtIdNumber>
    		And an initial deposit of $234.12
    		And a valid first name
    		And a valid last name
    When I attempt to create an account
    Then the account creation is <successStatus>   
      And the error is "<error>"

    Examples:
      | govtIdNumber   | successStatus | error                                          |
      | 3              | unsuccessful  | Government ID cannot be shorter than 10 digits |
      | 34567890123    | unsuccessful  | Government ID cannot be longer than 10 digits  |
      | 1234567890     | unsuccessful  | Government ID cannot start with a 1            |
      | 0234567890     | unsuccessful  | Government ID cannot start with a 0            |
      | 9234567890     | unsuccessful  | Government ID cannot start with a 9            |
      | 9234ABC890     | unsuccessful  | Government ID cannot have non-numeric values   |
      | 3456789012     | successful    |                                                |