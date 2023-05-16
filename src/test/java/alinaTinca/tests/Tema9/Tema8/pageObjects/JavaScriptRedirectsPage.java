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

import java.rmi.Remote;
import java.time.Duration;
import java.util.Set;

public class JavaScriptRedirectsPage {

    //Create the required attributes for this test case
    RemoteWebDriver remoteWebDriver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;

    //Create the constructor that can define the required parameters for this test case
    public JavaScriptRedirectsPage(RemoteWebDriver remoteWebDriver){
        this.remoteWebDriver = remoteWebDriver;
        wait = new WebDriverWait(remoteWebDriver, Duration.ofSeconds(5));
        fluentWait = new FluentWait<WebDriver>(remoteWebDriver)
                .withTimeout(Duration.ofSeconds(1))
                .pollingEvery(Duration.ofMillis(200));
        PageFactory.initElements(remoteWebDriver, this);
    }

    //Find the paragraph
    @FindBy (xpath = "//div[@class='explanation']/p")
    WebElement paragraph;

    //Create a method that display the message from the first paragraph
    public String getParagraph(){
        return paragraph.getText();
    }

    //Find the first button
    @FindBy(id = "delaygotobasic")
    WebElement firstButton;

    //Create a method that click on first button
    public void clickOnFirstButton(){
        firstButton.click();
        System.out.println("The first button has been clicked!");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("delaygotobasic")));
        System.out.println("Condition has been executed!");
    }

    //Find the second button
    @FindBy (id = "delaygotobounce")
    WebElement secondButton;

    //Create a method that click on the second button
    public void clickOnSecondButton(){
        secondButton.click();
        System.out.println("The second button has been clicked!");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("delaygotobounce")));
        System.out.println("Condition has been executed!");
    }
}