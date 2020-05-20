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


    @Then("user should verify that title is {string}")
    public void user_should_verify_that_title_is(String string) {
        System.out.println("Verify that title is Zero - Account Summary");
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(2);
        Assert.assertEquals(string, Driver.getDriver().getTitle());
    }

    @When("users try to log in with invalid username {string}")
    public void users_try_to_log_in_with_invalid_username(String string) {
        System.out.println("Login with invalid username");
        loginPage.login(string, "password");
        BrowserUtilities.waitForPageToLoad(10);
    }

    @Then("user should verify that error message is {string}")
    public void user_should_verify_that_error_message_is(String string) {

        System.out.println("User verifies that error message is displayed");
        BrowserUtilities.waitForPageToLoad(10);
        Assert.assertEquals(loginPage.getWarningMessageText(), string);
    }

    @When("users try to log in with invalid password {string}")
    public void users_try_to_log_in_with_invalid_password(String string) {
        System.out.println("Login with invalid password");
        loginPage.login("username", string);
        BrowserUtilities.waitForPageToLoad(10);
    }

    @When("users try to log in with blank user name")
    public void users_try_to_log_in_with_blank_user_name() {
        System.out.println("Login with blank username");
        loginPage.login("", "password");
        BrowserUtilities.waitForPageToLoad(10);
    }

    @When("users try to log in with blank password")
    public void users_try_to_log_in_with_blank_password() {
        System.out.println("Login with blank username");
        loginPage.login("username", "");
        BrowserUtilities.waitForPageToLoad(10);
    }
}
