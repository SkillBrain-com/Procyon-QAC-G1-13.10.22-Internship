package alinatinca.tests.Tema9.Tema5.Demoqa.Elements;


import alinatinca.driver.BrowserManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TextBox {

    public static void main(String[] args) {
        goToTheTextBoxAndCheckIt("Georgiana Alina","test@test.com","Bucharest","Romania");
    }
    //check if the method called goToTheTextBoxAndCheckIt is done successfully

    public static void goToTheTextBoxAndCheckIt(String fullNameInput, String EmailInput, String currentAddressInput, String permanentAddressInput) {
        //create the method called goToTheBoxAndCheckIt that goes to the section called Text Box and it identifies and makes several operations there
        RemoteWebDriver remoteWebDriver = BrowserManager.createRemoteWebDriver();
        //create and configure the Chrome browser page settings
        remoteWebDriver.get("https://demoqa.com/text-box");
        //go to Demoqa URL
        WebElement textBoxSection = remoteWebDriver.findElement(By.xpath("//span[text()='Text Box']"));
        //search the section called Text Box from the section called Elements
        textBoxSection.click();
        //click on the section calles Text Box
        WebElement fullNameField = remoteWebDriver.findElement(By.id("userName"));
        //search the Full Name field
        WebElement emailField = remoteWebDriver.findElement(By.id("userEmail"));
        //search the E-mail field
        WebElement currentAddressField = remoteWebDriver.findElement(By.id("currentAddress"));
        //search the Current Address field
        WebElement permanentAddressField = remoteWebDriver.findElement(By.id("permanentAddress"));
        //search the Permanent Address field
        fullNameField.click();
        //click on the Full Name field
        fullNameField.clear();
        //clear the previous data from the Full Name field
        fullNameField.sendKeys(fullNameInput);
        //introduce new full name
        fullNameField.sendKeys(Keys.TAB);
        //pass to the next field
        emailField.click();
        //click on the E-mail field
        emailField.clear();
        //clear the previous data from the Email filed
        emailField.sendKeys(EmailInput);
        //introduce new email
        emailField.sendKeys(Keys.TAB);
        //pass to the next field
        JavascriptExecutor js = (JavascriptExecutor) remoteWebDriver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        //scroll on the page
        currentAddressField.click();
        //click in the Current Address field
        currentAddressField.clear();
        //clear previous data from Current Address field
        currentAddressField.sendKeys(currentAddressInput);
        //introduce new current address
        currentAddressField.sendKeys(Keys.TAB);
        //pass to the next field
        permanentAddressField.click();
        //click on the Permanent Address field
        permanentAddressField.clear();
        //clear the previous data from the Permanent Address field
        permanentAddressField.sendKeys(permanentAddressInput);
        //introduce new permanent address
        permanentAddressField.sendKeys(Keys.TAB);
        //pass to the next field
        WebElement submitButton = remoteWebDriver.findElement(By.id("submit"));
        //find the button called Submit
        submitButton.sendKeys(Keys.ENTER);
        //click Enter on the Submit Button
        remoteWebDriver.quit();
        //close the Chrome browser page
    }
}