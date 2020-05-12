package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PayBillsPage extends AbstractBasePage{

    @FindBy(id="sp_payee")
    private WebElement payeeField;

   @FindBy(id="sp_account")
   private WebElement accountField;

   @FindBy(id="sp_amount")
   private WebElement amountField;

   @FindBy(id = "sp_date")
   private WebElement dateField;

   @FindBy(id = "sp_description")
   private WebElement descriptionField;

   @FindBy(id="pay_saved_payees")
   private WebElement payButton;

   @FindBy(xpath = "//span[contains(text(),'The payment was successfully submitted.')]")
   public WebElement successAlert;

   public void clickSubmitButton(){
      BrowserUtilities.waitForPageToLoad(2);
       payButton.click();
       BrowserUtilities.waitForPageToLoad(3);
   }

   public String getSuccessAlert(){
       BrowserUtilities.waitForPageToLoad(10);
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'The payment was successfully submitted.')]")));
       return successAlert.getText();
   }


    public void enterDescription(String description){
        wait.until(ExpectedConditions.visibilityOf(descriptionField));
        amountField.sendKeys(description);
        wait.until(ExpectedConditions.textToBePresentInElement(descriptionField, description));

    }
   public void enterDate(String date){
        wait.until(ExpectedConditions.visibilityOf(dateField));
        amountField.sendKeys(date, Keys.ENTER);
        wait.until(ExpectedConditions.textToBePresentInElement(dateField, date));
    }

   public void enterAmount(String amount){
   wait.until(ExpectedConditions.visibilityOf(amountField));
   amountField.sendKeys(amount, Keys.ENTER);
   BrowserUtilities.wait(5);

   }

   public void selectAccount(String accountName){
       accountField.click();
       String payeeXpath = "//option[contains(text(),'" + accountName + "')]";
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(payeeXpath)));
       driver.findElement(By.xpath(payeeXpath)).click();
       BrowserUtilities.waitForPageToLoad(3);
   }

    public void selectPayee(String payeeName){
        payeeField.click();
        String payeeXpath = "//option[contains(text(),'" + payeeName + "')]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(payeeXpath)));
        driver.findElement(By.xpath(payeeXpath)).click();
        BrowserUtilities.waitForPageToLoad(3);
    }

}
