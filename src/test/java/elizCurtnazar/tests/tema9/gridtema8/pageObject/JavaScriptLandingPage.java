package elizCurtnazar.tests.tema9.gridtema8.pageObject;

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

public class JavaScriptLandingPage {
    RemoteWebDriver remoteWebDriver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;

    public JavaScriptLandingPage(RemoteWebDriver remoteWebDriver) {
        this.remoteWebDriver = remoteWebDriver;
        //using WebDriverWait
        wait = new WebDriverWait(remoteWebDriver, Duration.ofSeconds(5));
        //using FluentWait
        fluentWait = new FluentWait<WebDriver>(remoteWebDriver)
                .withTimeout(Duration.ofSeconds(1))
                .pollingEvery(Duration.ofMillis(3));
        PageFactory.initElements(remoteWebDriver, this);
    }

    @FindBy(css = "div.explanation")
    WebElement paragraphText;

    @FindBy(id = "goback")
    WebElement goBackButton;

    public String getTextofParagraph() {
        return paragraphText.getText();
    }

    public void clickGoBackButton() {
        goBackButton.click();
        System.out.println("Go back to Java Redirect Page!");
    }
}
