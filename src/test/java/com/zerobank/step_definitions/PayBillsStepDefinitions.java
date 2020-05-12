package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class PayBillsStepDefinitions {

    PayBillsPage payBillsPage = new PayBillsPage();

    @Then("user should verify that title is Zero - Pay Bills")
    public void user_should_verify_that_title_is_Zero_Pay_Bills() {
        System.out.println("Verify that title is Zero - Pay Bills");
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(2);
        Assert.assertEquals("Zero - Pay Bills", Driver.getDriver().getTitle());
    }

    @When("user selects {string} option in Payee field")
    public void user_selects_option_in_Payee_field(String string) {
        System.out.println("User select Payee field");
    payBillsPage.selectPayee("Bank of America");

    }

    @When("user selects {string} in Account field")
    public void user_selects_in_Account_field(String string) {
        System.out.println("User select account type");
    payBillsPage.selectAccount("Checking");
    }

    @When("user enters payment information:")
    public void user_enters_payment_information(Map<String, String> dataTable) {
        System.out.println("User enter payment information");
    payBillsPage.enterAmount(dataTable.get("amount"));
    payBillsPage.enterDate(dataTable.get("date"));
    payBillsPage.enterDescription(dataTable.get("description"));
    payBillsPage.clickSubmitButton();

    }

    @Then("user should verify that {string} message is displayed")
    public void user_should_verify_that_message_is_displayed(String string) {
        System.out.println("User verifies that success message is displayed");
    Assert.assertEquals(payBillsPage.getSuccessAlert(), string);
    Assert.assertTrue(payBillsPage.successAlert.isDisplayed());
    }



}
