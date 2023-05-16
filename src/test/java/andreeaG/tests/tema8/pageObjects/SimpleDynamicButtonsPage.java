package andreeaG.tests.tema8.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

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
                .withTimeout(Duration.ofSeconds(1))
                .pollingEvery(Duration.ofMillis(200));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "button00")
    WebElement startButton;

    public void clickOnStartButton() {
        startButton.click();
    }

    public void clickOnOneButton() {
        //use either first option with WebDriverWait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button01")));
        //or second option with FluentWait
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button01")));
        WebElement buttonOne = driver.findElement(By.id("button01"));
        buttonOne.click();
    }

    public void clickOnSecondButton() {
        //use either first option with WebDriverWait
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
        //or second option with FluentWait
        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
        WebElement buttonTwo = driver.findElement(By.id("button02"));
        buttonTwo.click();
    }

    public void clickOnThirdButton(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
        WebElement buttonThree = driver.findElement(By.id("button03"));
        buttonThree.click();
    }

    @FindBy(id = "buttonmessage")
    WebElement allButtonsClicked;

    public String getCategoryText() {
        return allButtonsClicked.getText();
    }
}

