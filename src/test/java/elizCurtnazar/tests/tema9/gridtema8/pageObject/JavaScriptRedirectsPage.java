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

public class JavaScriptRedirectsPage {
    RemoteWebDriver remoteWebDriver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;

    public JavaScriptRedirectsPage(RemoteWebDriver remoteWebDriver) {
        this.remoteWebDriver = remoteWebDriver;
        //using WebDriverWait
        wait = new WebDriverWait(remoteWebDriver, Duration.ofSeconds(5));
        //using FluentWait
        fluentWait = new FluentWait<WebDriver>(remoteWebDriver)
                .withTimeout(Duration.ofSeconds(1))
                .pollingEvery(Duration.ofMillis(2));
        PageFactory.initElements(remoteWebDriver, this);
    }

    @FindBy(id = "delaygotobasic")
    WebElement firstButton;

    @FindBy(id = "delaygotobounce")
    WebElement secondButton;

    public void getParagraphText() {
        WebElement paragraph = remoteWebDriver.findElement(By.cssSelector("div.explanation"));
    paragraph.getText();
    }

    public void clickFirstButton() {
        firstButton.click();
        System.out.println("First button is clicked");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("delaygotobasic")));
    }

    public void clickSecondButton() {
        secondButton.click();
        System.out.println("Second button is clicked");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("delaygotobounce")));
    }
}
