package ancaMarian.tests.tema9.tema8.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.rmi.Remote;
import java.time.Duration;

public class DynamicButtonsSimplePage {

    RemoteWebDriver driver;
    WebDriverWait wait;

    public DynamicButtonsSimplePage(RemoteWebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "button00")
    WebElement startButton;

    public void waitForStartButtonToBeVisible() {
        wait.until(ExpectedConditions.visibilityOf(startButton));
    }

    public void clickOnStartButton() {
        startButton.click();
    }

    public void waitForOneButtonToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button01")));
    }

    public void clickOnOneButton() {
        WebElement oneButton = driver.findElement(By.id("button01"));
        oneButton.click();
    }

    public void waitForWaitMessageToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
    }

    public void clickOnTwoButton() {
        WebElement twoButton = driver.findElement(By.id("button02"));
        twoButton.click();
    }

    public void clickOnThreeButton() {
        WebElement threeButton = driver.findElement(By.id("button03"));
        threeButton.click();
    }

    public String confirmationMessage() {
        WebElement confirmationMessage = driver.findElement(By.id("buttonmessage"));
        return confirmationMessage.getText();
    }
}
