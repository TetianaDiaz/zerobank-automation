package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/zerobank/step_definitions",
        dryRun = false,
        tags = "@login",
        plugin = {"html:target/default-report",
                "json:target/cucumber1.json",
                "rerun:target/rerun.txt"}
)
public class TestRunner {
}


/*
@account_summary
Feature: Account summary page validation
  As user , I want to be able to see account information on Account Summary page

  Scenario: Account summary page
    Given user is on the login page
    When user logs in as an authorized user
    Then user should verify that title is Zero - Account Summary
    Then user should verify that Account Summary page has Cash Account type
    Then user should verify that Account Summary page has Investment Account type
    Then user should verify that Account Summary page has Credit Account type
    Then user should verify that Account Summary page has Loan Account type
    Then user should verify that Credit Accounts table has Account column
    Then user should verify that Credit Accounts table has Credit Card column
    Then user should verify that Credit Accounts table has Balance column



 */