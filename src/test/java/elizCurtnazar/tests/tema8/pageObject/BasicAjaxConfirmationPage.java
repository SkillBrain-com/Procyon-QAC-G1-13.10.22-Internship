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

public class BasicAjaxConfirmationPage {


    ChromeDriver driver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;
    public BasicAjaxConfirmationPage(ChromeDriver driver) {
        this.driver = driver;
        //using WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //using FluentWait
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(1))
                .pollingEvery(Duration.ofMillis(200));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "_valueid")
    WebElement categoryParagraph;

    @FindBy(id = "_valuelanguage_id")
    WebElement languageType;

    public String getCategoryText() {
        return categoryParagraph.getText();
    }

    public String getLanguageType() {
        return languageType.getText();
    }
}
