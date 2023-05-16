package andreeaG.tests.tema9.tema8.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavascriptRedirectButtons{
    RemoteWebDriver driver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;
    public JavascriptRedirectButtons(RemoteWebDriver driver) {
        this.driver = driver;
        //using WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        //using FluentWait
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="delaygotobasic" )
    WebElement click5Seconds;
    public void clickOn5Seconds() {
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200));
        click5Seconds.click();
        String originalHandle = driver.getWindowHandle();
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }   }
    }

    @FindBy (id="delaygotobounce")
    WebElement click2seconds;
    public void clickOn2seconds() {
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200));
        click2seconds.click();
        String originalHandle = driver.getWindowHandle();
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        } }
}
