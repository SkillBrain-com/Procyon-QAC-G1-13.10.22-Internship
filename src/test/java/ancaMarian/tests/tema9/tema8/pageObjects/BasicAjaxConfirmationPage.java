package ancaMarian.tests.tema9.tema8.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasicAjaxConfirmationPage {

    RemoteWebDriver driver;
    WebDriverWait wait;

    public BasicAjaxConfirmationPage(RemoteWebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "_valueid")
    WebElement categoryParagraph;

    public String getCategoryText() {
        return categoryParagraph.getText();
    }
}
