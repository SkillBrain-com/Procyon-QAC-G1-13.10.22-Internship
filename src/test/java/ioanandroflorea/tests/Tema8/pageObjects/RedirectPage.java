package ioanandroflorea.tests.Tema8.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RedirectPage {

    static ChromeDriver driver;
    static WebDriverWait wait;

    public RedirectPage(ChromeDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public static void clickOnRedirectIn5SecondsButton() {
        driver.findElement(By.id("delaygotobasic")).click();
    }

    public static void clickOnRedirectIn2SecondsButton() {
        driver.findElement(By.id("delaygotobounce")).click();
    }

    public static void waitToRedirect() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("javascript_countdown_time")));
    }
}