package alinatinca.tests.Tema9.Tema8.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class JavaScriptRedirectsConfirmationPage {

    //Create the required attributes for this test case
    RemoteWebDriver remoteWebDriver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;
    //Create the constructor that can define the required parameters for this test case
    public JavaScriptRedirectsConfirmationPage(RemoteWebDriver remoteWebDriver){
        this.remoteWebDriver = remoteWebDriver;
        wait = new WebDriverWait(remoteWebDriver, Duration.ofSeconds(5));
        fluentWait = new FluentWait<WebDriver>(remoteWebDriver)
            .withTimeout(Duration.ofSeconds(1))
            .pollingEvery(Duration.ofMillis(200));
        PageFactory.initElements(remoteWebDriver,this);
    }

    //Find the paragraph
    @FindBy (xpath = "//div[@class='explanation']/p")
    WebElement text;

    //Create a method that display the message that appear after the new window has been opened
    public String displayText(){
        return text.getText();
    }

    //Find Go Back button
    @FindBy (id = "goback")
    WebElement goBackButton;

    //Create a method that click on the Go Back button
    public void clickOnBackButton(){
        goBackButton.click();
        System.out.println("Back to main page!");
    }
}