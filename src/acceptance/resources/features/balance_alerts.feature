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