package catalinazoldi.tests.Tema9.Tema8.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RedirectPage {

     WebDriverWait wait;
     private RemoteWebDriver driver;


    public RedirectPage(RemoteWebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickToBeTransportedIn5SecondsButton() {
        driver.findElement(By.id("delaygotobasic")).click();
    }

    public void clickToBeTransportedIn2SecondsButton() {
        driver.findElement(By.id("delaygotobounce")).click();
    }

    public void waitForRedirect() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("javascript_countdown_time")));
    }

    public void clickOnRedirectIn5SecondsButton() {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickOnRedirectIn2SecondsButton() {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }
}


