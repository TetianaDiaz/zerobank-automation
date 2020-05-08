@account_activity
Feature: Account activity page validation
  As user , I want to be able to see account activity on Account Activity page

  Scenario: Account activity page
    Given user is on the login page
    When user logs in as an authorized user
    Then user navigates to "Account Activity" page
    Then user should verify that title is Zero - Account Activity
    Then user should verify that in Account drop down default option should be Savings
    And user should verify that Account drop down should have the following options:
    |Savings    |
    |Checking   |
    |Loan       |
    |Credit Card|
    |Brokerage  |
    And user should verify that transaction table have following column names:
    |Date       |
    |Description|
    |Deposit    |
    |Withdrawal |
