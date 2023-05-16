package ioanandroflorea.tests.Tema9.tema8.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DisabledDynamicButtonsPage {

    RemoteWebDriver driver;
    WebDriverWait wait;

    public DisabledDynamicButtonsPage(RemoteWebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "button00")
    WebElement startButton;

    @FindBy(id = "button01")
    WebElement oneButton;

    @FindBy(id = "button02")
    WebElement secondButton;

    @FindBy(id = "button03")
    WebElement thirdButton;

    public void waitForTheStartButtonToBeClickable() {
        wait.until(ExpectedConditions.visibilityOf(startButton));
    }

    public void clickOnStartButton() {
        startButton.click();
    }

    public void waitForOneButtonToBeClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button01")));
    }

    public void clickOnOneButton() {
        oneButton.click();
    }

    public void waitForTheMessageToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
    }

    public void clickOnSecondButton() {
        secondButton.click();
    }

    public void clickOnThirdButton() {
        thirdButton.click();
    }

    public String confirmationMessage() {
        WebElement confirmationMessage = driver.findElement(By.id("buttonmessage"));
        return confirmationMessage.getText();
    }
}

