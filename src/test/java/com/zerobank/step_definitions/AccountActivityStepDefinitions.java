package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

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
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user should verify that Account drop down should have the following options:")
    public void user_should_verify_that_Account_drop_down_should_have_the_following_options(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

    @Then("user should verify that transaction table have following column names:")
    public void user_should_verify_that_transaction_table_have_following_column_names(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }
}
