package neculaclaudiu.tests.seleniumpart3.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasicAjaxVerificationPage{
    ChromeDriver driver;
    WebDriverWait wait;

    public BasicAjaxVerificationPage(ChromeDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "_valueid")
    WebElement categoryText;

    @FindBy(id = "_valuelanguage_id")
    WebElement languageText;

    public String getCategoryText(){
        return categoryText.getText();
    }

    public String getLanguageText(){
        return languageText.getText();
    }
}
