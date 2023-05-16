package alinatinca.tests.Tema9.Tema8.pageObjects;

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

public class SimpleDynamicButtonPage {

    //Create the required attributes for this test case
    RemoteWebDriver remoteWebDriver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;

    //Create the constructor that can define the required parameters for this test case
    public SimpleDynamicButtonPage(RemoteWebDriver remoteWebDriver){
        this.remoteWebDriver = remoteWebDriver;
        wait = new WebDriverWait(remoteWebDriver, Duration.ofSeconds(5));
        fluentWait = new FluentWait<WebDriver>(remoteWebDriver).withTimeout(Duration.ofSeconds(1)).pollingEvery(Duration.ofMillis(200));
        PageFactory.initElements(remoteWebDriver, this);
    }

    //Find the start button on the page
    @FindBy(id="button00")
    WebElement startButton;

    //Create a method that click on the start button
    public void clickOnStartButton(){
        startButton.click();
        System.out.println("Start button has been opened!");
    }

    //Find the one button on the page
    @FindBy(id="button01")
    WebElement oneButton;

    //Create a method that click on the one button
    public void clickOnOneButton(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button01")));
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button01")));
        System.out.println("Condition has been executed!");
        oneButton.click();
        System.out.println("One button has been opened!");
    }

    //Find the second button
    @FindBy(id="button02")
    WebElement secondButton;

    //Create a method that click on the second button
    public void clickOnSecondButton(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
//        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
        System.out.println("Condition has been executed!");
        secondButton.click();
    }

    //Find the third button
    @FindBy (id="button03")
    WebElement thirdButton;

    //Create a method that click on the third button
    public void clickOnThirdButton(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
        System.out.println("Condition has been executed!");
        thirdButton.click();
        System.out.println("The third button has been opened!");
    }
}