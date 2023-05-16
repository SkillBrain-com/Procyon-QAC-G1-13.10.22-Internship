package catalinazoldi.tests.Tema8.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RedirectPage {
     ChromeDriver driver;
     WebDriverWait wait;


    public RedirectPage(ChromeDriver driver) {
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
}

