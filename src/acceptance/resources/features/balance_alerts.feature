@skip
Feature: Balance alerts
  Let users know when their balance is under $50 by sending an 
  end of day alert to their primary email address

  Scenario: No alert
    Given an account with a balance of $51
    When the end of day email alert job runs
    Then an alert is not sent

  Scenario: Low balance alert
    Given an account with a balance of $49
    When the end of day email alert job runs
    Then an alert is sent to the primary email on the account
    
    
    
    Scenario: deposit check
    1 customer account  number to deposit ,checking account nummber(between 8 to 12, cannot start with 0),routing number(exact 9, cannot start with 0),amount ,date,
    2 reqirement,: 1deposit under 500,  status of success-->show account balance,
                  2 deposit above 500, send to FBI ,has status of pending,dosnt appear balance
                  3 send transaction to bank,
                  4 build clearing house, call when deposit check ,if clear,return success/fail
                  
                  
                  
    TEST CASE:
    1 get account number,routing number,customer account, valid check,
    2 deposit < 500,  transaction success,return transaction true,
    3 deposit => 500 ,transaction pending, return transaction pending ,
    4 transaction true ,return status available,
    5 transaction false,return status pending ,
    6 deposit >10000, send to fbi flag true,