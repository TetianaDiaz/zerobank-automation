package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {


    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("I am on the login page");
        String URL = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
    }

    @When("user logs in as an authorized user")
    public void user_logs_in_as_an_authorized_user() {
        System.out.println("Login as authorized user");
        loginPage.login("username", "password");
    }

    @Then("user should verify that title is Zero - Account Summary")
    public void user_should_verify_that_title_is_Zero_Account_Summary() {
        System.out.println("Verify that title is Zero - Account Summary");
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(2);
        Assert.assertEquals("Zero - Account Summary", Driver.getDriver().getTitle());
    }

}
