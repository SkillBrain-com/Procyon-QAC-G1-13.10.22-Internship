package alinatinca.tests.Tema9.Tema8.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class DisabledDynamicButtonConfirmationPage {

    //Create the required attributes for this test case
    RemoteWebDriver remoteWebDriver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;

    //Create the constructor that can define the required parameters for this test case
    public DisabledDynamicButtonConfirmationPage(RemoteWebDriver remoteWebDriver) {
        this.remoteWebDriver = remoteWebDriver;
        wait = new WebDriverWait(remoteWebDriver, Duration.ofSeconds(5));
        fluentWait = new FluentWait<WebDriver>(remoteWebDriver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(200));
        PageFactory.initElements(remoteWebDriver, this);
    }

    //Find the text on the page
    @FindBy(id = "buttonmessage")
    WebElement text;

    //Create a method that display the text for opening all buttons
    public String displayTextForClickAllButtons() {
        return text.getText();
    }
}