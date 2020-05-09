package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AccountActivityStepDefinitions {

    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Then("user navigates to {string} page")
    public void user_navigates_to_page(String string) {
        System.out.println("User navigates to Account Activity page");
        accountActivityPage.navigateTo(string);
    }

    @Then("user should verify that title is Zero - Account Activity")
    public void user_should_verify_that_title_is_Zero_Account_Activity() {
        System.out.println("Verify that title is Zero - Account Activity");
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(2);
        Assert.assertEquals("Zero - Account Activity", Driver.getDriver().getTitle());
    }

    @Then("user should verify that in Account drop down default option should be Savings")
    public void user_should_verify_that_in_Account_drop_down_default_option_should_be_Savings() {
        String option = accountActivityPage.checkDefaultAccountDropDownOption();
        Assert.assertEquals(option, "Savings");
    }


    @When("user clicks on Account drop down following option should be present:")
    public void user_clicks_on_Account_drop_down_following_option_should_be_present(List<String> dataTable) {
        System.out.println("Expected options: " + dataTable);
       Assert.assertEquals(dataTable, accountActivityPage.getAccountDropDownOptions());
    }


    @Then("user should verify that transaction table have following column names:")
    public void user_should_verify_that_transaction_table_have_following_column_names(List<String> dataTable) {
        System.out.println("Verify that " + dataTable + " columns is present");
        Assert.assertEquals(dataTable, accountActivityPage.getTransactionTableOptions());
    }
}
