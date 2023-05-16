package andreeaG.tests.tema9.tema5.demoqa;

import andreeaG.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TextBox { public static void main(String[] args) {
    goToTextBox();
    goToEmail();
    goToCurrentAddress();
    goToPermanentAddress();
    submitButton(); }

    private static void goToTextBox() {
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://demoqa.com/text-box");
        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("Ana Norwich");
        driver.quit();
    }

    public static void goToEmail() {
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://demoqa.com/text-box");
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("ANorwich@gmail.com");
        driver.quit(); }

    public static void goToCurrentAddress() {
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://demoqa.com/text-box");
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys(" str. Eroilor, Timisoara");
        driver.quit();
    }

    public static void goToPermanentAddress() {
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://demoqa.com/text-box");
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(" str.Noway, China");
        driver.quit();
    }

    public static void submitButton() {
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://demoqa.com/text-box");
        WebElement blueSubmitButton = driver.findElement(By.id("submit"));
        blueSubmitButton.click();
        System.out.println( "Am dat click la Submit!");
        driver.quit();
    }
}


