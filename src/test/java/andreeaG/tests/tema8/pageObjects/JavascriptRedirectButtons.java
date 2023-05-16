package andreeaG.tests.tema8.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavascriptRedirectButtons{

    //https://testpages.herokuapp.com/styled/javascript-redirect-test.html -
    // se vor verifica butoanele care redirectează către o pagină noua,
    // folosind wait si windowHandles

    ChromeDriver driver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;
    public JavascriptRedirectButtons(ChromeDriver driver) {
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
