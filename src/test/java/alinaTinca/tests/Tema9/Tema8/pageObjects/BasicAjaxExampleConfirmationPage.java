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

public class BasicAjaxExampleConfirmationPage {

    //Create the required attributes for this test case
    RemoteWebDriver remoteWebDriver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;

    //Create the constructor that can define the required parameters for this test case
    public BasicAjaxExampleConfirmationPage(RemoteWebDriver remoteWebDriver){
        this.remoteWebDriver = remoteWebDriver;
        wait = new WebDriverWait(remoteWebDriver, Duration.ofSeconds(5));
        fluentWait = new FluentWait<WebDriver>(remoteWebDriver).withTimeout(Duration.ofSeconds(1)).pollingEvery(Duration.ofMillis(200));
        PageFactory.initElements(remoteWebDriver, this);
    }

    //Find Category ID element from the page
    @FindBy(id = "_valueid")
    WebElement categoryParagpraphID;

    //Create a method that display the selected language id category
    public String getCategoryID(){
        return categoryParagpraphID.getText();
    }

    //Find Language Id element from the page
    @FindBy(id="_valuelanguage_id")
    WebElement categoryParagpraphLanguage;

    //Create a method that display the selected language id category
    public String getCategoryLanguage() {
        return categoryParagpraphLanguage.getText();
    }
}