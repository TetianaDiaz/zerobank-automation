@account_summary
Feature: Account summary page validation
  As user , I want to be able to see account information on Account Summary page

  Scenario: Account summary page
    Given user is on the login page
    When user logs in as an authorized user
    Then user should verify that title is Zero - Account Summary
    Then user should verify that Account Summary page has Account Types:
    |Cash Accounts      |
    |Investment Accounts|
    |Credit Accounts    |
    |Loan Accounts      |

    Then user should verify that Credit Accounts table has Columns:
    |Account    |
    |Credit Card|
    |Balance    |
