package sorinfoca.Tests.Tema9.Tema8.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptRedirectPage {
    private final WebDriver driver;
    private final String url;

    public JavaScriptRedirectPage(WebDriver driver) {
        this.driver = driver;
        this.url = "https://testpages.herokuapp.com/styled/javascript-redirect-test.html";
    }

    public void goToPage() {
        driver.get(url);
    }

    public void clickRedirectButton() {
        driver.findElement(By.id("delaygotobasic")).click();
    }

    public void waitForRedirect() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleContains("Redirected Landing Page"));
    }
}