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

  Scenario: First name is invalid
    Given a valid government id number
    		And an initial deposit of $199.99
    		And an invalid first name
    		And a valid last name
    When I attempt to create an account
    Then the account creation is unsuccessful        

  Scenario: Last name is invalid
    Given a valid government id number
    		And an initial deposit of $199.99
    		And a valid first name
    		And an invalid last name
    When I attempt to create an account
    Then the account creation is unsuccessful       

  Scenario Outline: Invalid government id number
    Given a government id number of <accountNumber>
    		And an initial deposit of $234.12
    		And a valid first name
    		And a valid last name
    When I attempt to create an account
    Then the account creation is <successStatus> 

    Examples:
      | accountNumber  | successStatus | reason                 |
      | 3              | unsuccessful  | Shorter than 10 digits |
      | 34567890123    | unsuccessful  | Shorter than 10 digits |
      | 1234567890     | unsuccessful  | Can't start with a 1   |
      | 0234567890     | unsuccessful  | Can't start with a 0   |
      | 9234567890     | unsuccessful  | Can't start with a 9   |
      | 9234ABC890     | unsuccessful  | Can't have non-numeric |
      | 3456789012     | successful    | Valid                  |