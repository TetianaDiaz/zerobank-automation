package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends AbstractBasePage {

    @FindBy(id="aa_accountId")
    private WebElement accountDropDown;

    @FindBy(xpath = "//option")
    private List<WebElement> accountDropDownOptions;

    @FindBy(xpath = "//table/thead/tr/th")
    private List<WebElement> tableColumns;

    public List<String> getTransactionTableOptions(){
        BrowserUtilities.waitForPageToLoad(20);
        BrowserUtilities.wait(2);
        return BrowserUtilities.getTextFromWebElements(tableColumns);
    }

    public String checkDefaultAccountDropDownOption(){
        Select drop = new Select(accountDropDown);
        return drop.getFirstSelectedOption().getText();
    }


    public List<String> getAccountDropDownOptions(){
        BrowserUtilities.waitForPageToLoad(20);
        accountDropDown.click();
        BrowserUtilities.wait(2);
        return BrowserUtilities.getTextFromWebElements(accountDropDownOptions);
    }


}
