package ancaMarian.tests.tema8.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RefreshPage {

    ChromeDriver driver;
    WebDriverWait wait;
    String timestamp;

    public RefreshPage(ChromeDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void waitForIdToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("refreshdate")));
    }

    public String getTimestamp() {
        timestamp = driver.findElement(By.id("refreshdate")).getText();
        return timestamp;
    }
}
