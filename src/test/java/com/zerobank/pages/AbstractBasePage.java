package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractBasePage {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 25);

    public AbstractBasePage(){
        PageFactory.initElements(driver, this);
    }

    public void navigateTo(String tabName){
        String tabNameXpath = "//a[contains(text(),'"+tabName+"')]";
        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        tabElement.click();

        //increase wait time if still failing
        BrowserUtilities.wait(6);
        waitForLoaderMask();
    }

    /**
     * this method can be used to wait until that terrible loader mask (spinning circle) will be gone
     * if loader mask is present, website is loading some data and you cannot perform any operations
     * @return
     */
    public void waitForLoaderMask(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class*='loader-mask']")));
    }

}
