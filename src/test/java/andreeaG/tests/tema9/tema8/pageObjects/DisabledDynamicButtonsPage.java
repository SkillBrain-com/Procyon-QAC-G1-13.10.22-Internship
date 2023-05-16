package andreeaG.tests.tema9.tema8.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class DisabledDynamicButtonsPage {
    RemoteWebDriver driver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;
    public DisabledDynamicButtonsPage(RemoteWebDriver driver) {
        this.driver = driver;
        //using WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //using FluentWait
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "button00")
    WebElement startButton;
    public void setStartButton() {
        // second option with FluentWait
        fluentWait.until(ExpectedConditions.elementToBeClickable(By.id("button00")));
    }

    public void clickStartButton() {
        startButton.click();
    }

    public void clickOnOneButton() {
        fluentWait.until(ExpectedConditions.elementToBeClickable(By.id("button01")));
        WebElement buttonOne = driver.findElement(By.id("button01"));
        buttonOne.click();
    }

    public void clickOnSecondButton() {
        // second option with FluentWait
        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
        WebElement buttonTwo = driver.findElement(By.id("button02"));
        buttonTwo.click();
    }

    public void clickOnThirdButton(){
        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
        WebElement buttonThree = driver.findElement(By.id("button03"));
        buttonThree.click();
    }

    @FindBy(id = "buttonmessage")
    WebElement clickButtonsInOrder;

    public String messageDisplay() {
        return clickButtonsInOrder.getText();
    }
}
