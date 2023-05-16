package elizCurtnazar.tests.tema8.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptLandingPage {
    ChromeDriver driver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;

    public JavaScriptLandingPage(ChromeDriver driver) {
        this.driver = driver;
        //using WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //using FluentWait
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(1))
                .pollingEvery(Duration.ofMillis(3));
        PageFactory.initElements(driver, this);
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
