@pay_bills
Feature: Pay bills page validation
  As user , I want to be able to see Pay Bills page

@positive_scenario
  Scenario: Pay Bills page positive
    Given user is on the login page
    When user logs in as an authorized user
    Then user navigates to "Pay Bills" page
    Then user should verify that title is Zero - Pay Bills
    When user selects "Bank of America" option in Payee field
    And user selects "Checking" in Account field
    And user enters payment information:
      |date       |2020-05-13|
      |amount     |100|
      |description|May 2020|
  Then user should verify that "The payment was successfully submitted." message is displayed

  @negative_scenario_without_the_date
  Scenario: Pay Bills page negative 1
    Given user is on the login page
    When user logs in as an authorized user
    Then user navigates to "Pay Bills" page
    Then user should verify that title is Zero - Pay Bills
    When user selects "Bank of America" option in Payee field
    And user selects "Checking" in Account field
    And user enters payment information:
      |amount     | 100     |
      |description| May 2020|
    Then user should verify that "Please fill out this field." message is displayed

  @negative_scenario_without_the_amount
  Scenario: Pay Bills page negative 2
    Given user is on the login page
    When user logs in as an authorized user
    Then user navigates to "Pay Bills" page
    Then user should verify that title is Zero - Pay Bills
    When user selects "Bank of America" option in Payee field
    And user selects "Checking" in Account field
    And user enters payment information:
      |date       | 2020-05-20|
      |description| May 2020  |
    Then user should verify that "Please fill out this field." message is displayed



