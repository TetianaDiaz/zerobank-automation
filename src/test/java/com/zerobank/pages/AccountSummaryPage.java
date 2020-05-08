package com.zerobank.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class AccountSummaryPage extends AbstractBasePage {


    public void verifyAccountTabIsPresent(String accountTab) {
        String accountTabXpath = "//h2[contains(text(),'" + accountTab + "')]";
        WebElement tabElement = driver.findElement(By.xpath(accountTabXpath));
        Assert.assertTrue(tabElement.isDisplayed());
        Assert.assertEquals(accountTab, tabElement.getText());
    }

    public void verifyCreditAccountColumns(int columnsNumber, String columnName){
        String accountColumnsXpath = "(//table)[3]/thead/tr/th["+columnsNumber+"]";
        WebElement columnElement = driver.findElement(By.xpath(accountColumnsXpath));
        Assert.assertTrue(columnElement.isDisplayed());
        Assert.assertEquals(columnElement.getText(), columnName);
    }
}
