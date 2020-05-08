@login
Feature: Login
  As user , I want to be able to login with username and password

  Background: open login page
    Given user is on the login page

  @login
  Scenario: Login as authorized user
    When user logs in as an authorized user
    Then user should verify that title is Zero - Account Summary


