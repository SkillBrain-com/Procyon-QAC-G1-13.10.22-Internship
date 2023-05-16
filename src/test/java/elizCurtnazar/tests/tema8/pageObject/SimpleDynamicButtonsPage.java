package elizCurtnazar.tests.tema8.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import java.time.Duration;

public class SimpleDynamicButtonsPage {

    ChromeDriver driver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;
    public SimpleDynamicButtonsPage(ChromeDriver driver) {
        this.driver = driver;
        //using WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //using FluentWait
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1));
        PageFactory.initElements(driver, this);
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
        WebElement buttonOne = driver.findElement(By.id("button01"));
        buttonOne.click();
        System.out.println("One button clicked!");
    }

    public void clickOnSecondButton() {
        //use either first option with WebDriverWait
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
        //or second option with FluentWait
        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
        WebElement buttonTwo = driver.findElement(By.id("button02"));
        buttonTwo.click();
        System.out.println("Two button clicked!");
    }

    public void clickOnThirdButton() {
        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
        WebElement buttonThree = driver.findElement(By.id("button03"));
        buttonThree.click();
        System.out.println("Three button clicked!");
    }

    public String getButtonMessage() {

        return buttonMessage.getText();
    }
}