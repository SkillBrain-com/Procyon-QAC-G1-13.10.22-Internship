package cosminsechel.tests.tema8.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RefreshPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String initialTimestamp;

    public RefreshPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void goToPage() {
        driver.get("https://testpages.herokuapp.com/styled/refresh");
    }

    public String getInitialTimestamp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("refreshdate")));
        initialTimestamp = driver.findElement(By.id("refreshdate")).getText();
        return initialTimestamp;
    }
}
