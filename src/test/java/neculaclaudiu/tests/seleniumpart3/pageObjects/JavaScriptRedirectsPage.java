package neculaclaudiu.tests.seleniumpart3.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptRedirectsPage {

    ChromeDriver driver;
    WebDriverWait wait;

    public JavaScriptRedirectsPage(ChromeDriver driver){
        this.driver = driver;
        this.driver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "delaygotobasic")
    WebElement transportedIn5SecondsButton;

    @FindBy(id = "delaygotobounce")
    WebElement transportedIn2SecondsButton;

    @FindBy(id = "goback")
    WebElement goBackButton;

    public void clickOnFirstButton(){
        transportedIn5SecondsButton.click();
    }

    public void clickOnTheSecondButton(){
        transportedIn2SecondsButton.click();
    }

    public void waitForRedirect(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("javascript_countdown_time")));
    }

    public void goBackButton(){
        goBackButton.click();
    }
}
