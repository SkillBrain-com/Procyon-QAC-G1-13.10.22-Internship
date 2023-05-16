package elizCurtnazar.tests.tema9.gridtema8.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SimpleDynamicButtonsPage {

    RemoteWebDriver remoteWebDriver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;
    public SimpleDynamicButtonsPage(RemoteWebDriver remoteWebDriver) {
        this.remoteWebDriver = remoteWebDriver;
        //using WebDriverWait
        wait = new WebDriverWait(remoteWebDriver, Duration.ofSeconds(5));
        //using FluentWait
        fluentWait = new FluentWait<WebDriver>(remoteWebDriver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1));
        PageFactory.initElements(remoteWebDriver, this);
    }

    @FindBy(id = "button00")
    WebElement startButton;

    @FindBy(id = "buttonmessage")
    WebElement buttonMessage;


    public void clickOnStartButton() {

        startButton.click();
        System.out.println("Start button clicked!");
    }

    public void clickOnOneButton() {
        //use either first option with WebDriverWait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button01")));
        //or second option with FluentWait
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button01")));
        WebElement buttonOne = remoteWebDriver.findElement(By.id("button01"));
        buttonOne.click();
        System.out.println("One button clicked!");
    }

    public void clickOnSecondButton() {
        //use either first option with WebDriverWait
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
        //or second option with FluentWait
        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
        WebElement buttonTwo = remoteWebDriver.findElement(By.id("button02"));
        buttonTwo.click();
        System.out.println("Two button clicked!");
    }

    public void clickOnThirdButton() {
        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
        WebElement buttonThree = remoteWebDriver.findElement(By.id("button03"));
        buttonThree.click();
        System.out.println("Three button clicked!");
    }

    public String getButtonMessage() {

        return buttonMessage.getText();
    }
}