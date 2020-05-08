package com.zerobank.step_definitions;


import com.zerobank.pages.AccountSummaryPage;
import io.cucumber.java.en.Then;

import java.util.List;

public class AccountSummaryStepDefinitions {

    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @Then("user should verify that Account Summary page has Account Types:")
    public void user_should_verify_that_Account_Summary_page_has_Account_Types(List<String> dataTable) {
        for (int i = 0; i <dataTable.size() ; i++) {
            System.out.println("Verify that " + dataTable.get(i) + " tab is present");
            accountSummaryPage.verifyAccountTabIsPresent(dataTable.get(i));
        }
    }

    @Then("user should verify that Credit Accounts table has Columns:")
    public void user_should_verify_that_Credit_Accounts_table_has_Columns(List<String> dataTable) {
        for (int i = 0; i <dataTable.size() ; i++) {
            System.out.println("Verify that " + dataTable.get(i) + " column is present");
            accountSummaryPage.verifyCreditAccountColumns(i+1, dataTable.get(i) );

        }
    }



}
