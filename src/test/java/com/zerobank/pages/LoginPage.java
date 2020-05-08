package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.plaf.PanelUI;

public class LoginPage extends AbstractBasePage{

    @FindBy(id = "user_login")
    public WebElement loginField;

    @FindBy(id = "user_password")
    public WebElement passwordField;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement signInBtn;

    @FindBy (xpath = "//a[@href='/forgot-password.html']")
    private WebElement forgotPassword;

    @FindBy (xpath = "/html/head/title")
    private WebElement title;

    @FindBy (css= "[class='alert alert-error']")
    private WebElement warningMessage;

    public String getWarningMessageText(){
        return warningMessage.getText();
    }


    public void login(String usernameValue, String passwordValue){
        loginField.sendKeys(usernameValue);
        passwordField.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);
    }

    /**
     * Method to login, version #2
     * Login as a default user
     * Credentials will be retrieved from configuration.properties file
     */
    public void login(){
        loginField.sendKeys(ConfigurationReader.getProperty("username"));
        passwordField.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);
    }

}
