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

public class DisableDynamicButtonsPage {

    RemoteWebDriver remoteWebDriver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;

    public DisableDynamicButtonsPage(RemoteWebDriver remoteWebDriver) {
        this.remoteWebDriver = remoteWebDriver;
        //using WebDriverWait
        wait = new WebDriverWait(remoteWebDriver, Duration.ofSeconds(9));
        //using FluentWait
        fluentWait = new FluentWait<WebDriver>(remoteWebDriver)
                .withTimeout(Duration.ofSeconds(1))
                .pollingEvery(Duration.ofMillis(8));
        PageFactory.initElements(remoteWebDriver, this);
    }

    @FindBy(id = "buttonmessage")
    WebElement buttonMessage;

    @FindBy(id = "button00")
    WebElement startButton;

    @FindBy(id = "button01")
    WebElement buttonOne;

    @FindBy(id = "button02")
    WebElement buttonTwo;

    @FindBy(id = "button03")
    WebElement buttonThree;

    public void clickStartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button00")));
        startButton.click();
        System.out.println("Start button is clicked!");
    }

    public void clickButtonOne() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button01")));
        buttonOne.click();
        System.out.println("One button is clicked!");

    }
    public void clickButtonsTwo() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button02")));
        buttonTwo.click();
        System.out.println("Two button is clicked!");

    }
    public void clickButtonThree() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button03")));
        buttonThree.click();
        System.out.println("Three button is clicked!");
    }
    public String getMessage() {
        return buttonMessage.getText();
    }
}


