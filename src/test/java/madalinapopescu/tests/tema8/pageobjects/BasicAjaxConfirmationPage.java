package madalinapopescu.tests.tema8.pageobjects;

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

    public BasicAjaxConfirmationPage(ChromeDriver driver){
        this.driver = driver;
        //using WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //using FluentWait
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200));
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="_valueid")
    WebElement categoryParaghraph;

    public String getCategoryText(){
       return categoryParaghraph.getText();
    }
    @FindBy(id="_valuelanguage_id")
    WebElement languageParaghraph;

    public String getLanguageText(){
        return languageParaghraph.getText();
    }
    @FindBy(id="_valuesubmitbutton")
    WebElement submitButton;

    public String getsubmitButtonText(){
        return submitButton.getText();
    }

}
